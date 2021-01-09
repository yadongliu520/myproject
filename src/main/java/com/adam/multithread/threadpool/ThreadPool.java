package com.adam.multithread.threadpool;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-08-04 09:39
 **/
public interface ThreadPool<Job extends Runnable> {
     void execute(Job job);
     void shutdown();
     void addWorkers(int num);
     void removeWorker(int num);
     int getJobSize();
}
