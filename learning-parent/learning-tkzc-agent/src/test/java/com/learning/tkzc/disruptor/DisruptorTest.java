package com.learning.tkzc.disruptor;

import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DisruptorTest {

    @Test
    public void test01() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        int bufferSize = 1024;

        Disruptor<MyEvent> disruptor = new Disruptor<>(new MyEventFactory(),
                bufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.handleExceptionsWith(new IgnoreExceptionHandler());

        disruptor.handleEventsWith(new MyEventHandler(), new MyEventHandler());
        RingBuffer<MyEvent> ringBuffer = disruptor.start();

        MyEventProducer producer = new MyEventProducer(ringBuffer);
        for (long i = 0; i < 10; i++) {
            producer.onData(i);
            Thread.sleep(1000);// wait for task execute....
        }

        disruptor.shutdown();

        ExecutorUtils.shutdownAndAwaitTermination(executorService, 60, TimeUnit.SECONDS);
    }

    @Test
    public void test02() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        int bufferSize = 1024;

        Disruptor<MyEvent> disruptor = new Disruptor<>(new MyEventFactory(),
                bufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.handleExceptionsWith(new IgnoreExceptionHandler());
        disruptor.handleEventsWithWorkerPool(new MyEventWorkHandler("worker-1"), new MyEventWorkHandler("worker-2"));
        RingBuffer<MyEvent> ringBuffer = disruptor.start();

        MyEventProducer producer = new MyEventProducer(ringBuffer);
        for (long i = 0; i < 10; i++) {
            producer.onData(i);
            Thread.sleep(1000);// wait for task execute....
        }

        disruptor.shutdown();

        ExecutorUtils.shutdownAndAwaitTermination(executorService, 60, TimeUnit.SECONDS);
    }

    @Test
    public void test03() {
        String loggingRoot = System.getProperty("loggingRoot");
        System.out.println(loggingRoot);
    }

}
