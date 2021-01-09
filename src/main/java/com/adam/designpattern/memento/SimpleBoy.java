package com.adam.designpattern.memento;

/**
 * @Description:
 * @Author: Adam
 * @Date: 2020-09-27 00:07
 **/
public class SimpleBoy implements Cloneable {
    private SimpleBoy backup;
    private String state;

    public void createMemento(){
        this.backup=this.clone();
    }
    public void restoreMemento(){
        this.setState(this.backup.getState());
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void changeState(){
        this.setState("I am not fine.");
    }

    @Override
    public SimpleBoy clone(){
        SimpleBoy simpleBoy=null;
        try{
            simpleBoy=(SimpleBoy)super.clone();
        }catch (CloneNotSupportedException e){e.printStackTrace();}
        return simpleBoy;
    }
}
