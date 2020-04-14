package com.learning.tkzc.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class MyEventProducer {

    private RingBuffer<MyEvent> ringBuffer;

    public MyEventProducer(RingBuffer<MyEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg TRANSLATOR = (EventTranslatorOneArg<MyEvent, Long>) (event, sequence, value) -> event.setValue(value);

    public void onData(final Long value) {
        ringBuffer.publishEvent(TRANSLATOR,value);
    }
}
