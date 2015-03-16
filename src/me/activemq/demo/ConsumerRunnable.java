package me.activemq.demo;

/**
 * Author: EthanTu <ethan.l.tu@gmail.com>
 * Date: 2015/2/28
 * Time: 19:34
 */
public class ConsumerRunnable implements Runnable {

    private Consumer consumer;

    public ConsumerRunnable(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while(true) {
            consumer.receive("2");
        }
    }
}
