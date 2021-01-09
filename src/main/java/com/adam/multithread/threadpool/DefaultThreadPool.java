package com.adam.multithread.threadpool;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-04 09:46
 **/
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    private static final int MAX_WORKER_NUMBERS = 10;
    private static final int MIN_WORKER_NUMBERS = 1;
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private final LinkedList<Job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    private AtomicLong threadNum = new AtomicLong();
    private void initWorkers(int num){
        for(int i=0;i<num;i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "Worker-thread" + threadNum.incrementAndGet());
            thread.start();
        }
    }
    public DefaultThreadPool(int num){
        //构建num个工作者，并添加到工作者队列
        workerNum = num>MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
        initWorkers(workerNum);
    }

    class Worker implements Runnable{
        private  volatile boolean running=true;
        @Override
        public void run() {
            while(running){
                Job job=null;
                synchronized (jobs){
                    while(jobs.isEmpty()){
                        try{
                            jobs.wait();
                        }catch (InterruptedException e){Thread.currentThread().interrupt(); return;}
                    }
                    job = jobs.removeFirst();
                    }
                    if(job!=null)job.run();
                }
            }

        public void shutdown(){
            //定义一个标识位来做关闭
            running = false;
        }
    }

    @Override
    public void execute(Job job) {
        //添加到工作队列，并通知
        if(job!=null){
            synchronized (jobs){
                jobs.add(job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void shutdown() {
        //工作者队列挨个删除
        for(Worker worker:workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        //增加到工作者队列，并更新最新的工作者数量
        synchronized(workers){
            if(num + workerNum>MAX_WORKER_NUMBERS)
                num = MAX_WORKER_NUMBERS - workerNum;
            initWorkers(num);
            workerNum +=num;
        }
    }

    @Override
    public void removeWorker(int num) {
        //工作者队列移除工作者，并关闭
        synchronized(workers){
            if(num>workerNum) throw new IllegalArgumentException();
            for(int i=0;i<num;i++){
                Worker worker = workers.get(i);
                if(workers.remove(worker)) worker.shutdown();
            }
            workerNum -=num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
}
