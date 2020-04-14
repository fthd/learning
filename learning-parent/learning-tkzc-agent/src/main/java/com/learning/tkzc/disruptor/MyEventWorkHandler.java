package com.learning.tkzc.disruptor;

import com.lmax.disruptor.WorkHandler;

public class MyEventWorkHandler implements WorkHandler<MyEvent> {

    private String workerName;

    public MyEventWorkHandler(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public void onEvent(MyEvent event) {
        System.out.println(workerName + " handle event:" + event);
    }
}
