package me.activemq.demo;

import me.activemq.demo.domain.model.email.EmailObject;

/**
 * Author: EthanTu <ethan.l.tu@gmail.com>
 * Date: 2015/2/28
 * Time: 19:34
 */
public class SendRunnable implements Runnable {

    private Publisher publisher;

    private String name;

    public SendRunnable(String name, Publisher publisher) {
        this.publisher = publisher;
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        while (i++ < 1000) {
            EmailObject emailObject = new EmailObject();
            emailObject.setData(name + "[" + i + "]I'm strong");
            emailObject.setQueueName("email");
            emailObject.setProcessName("email");
            emailObject.setExt(null);
            emailObject.setCallback(null);
            publisher.send("2", emailObject);
        }
    }
}
