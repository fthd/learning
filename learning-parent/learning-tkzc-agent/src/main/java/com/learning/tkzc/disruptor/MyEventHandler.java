package com.learning.tkzc.disruptor;

import com.lmax.disruptor.EventHandler;

public class MyEventHandler implements EventHandler<MyEvent> {
    @Override
    public void onEvent(MyEvent event, long sequence, boolean endOfBatch) {
        System.out.println(event);
    }
}
