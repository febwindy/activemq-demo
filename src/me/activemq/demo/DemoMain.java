package me.activemq.demo;

import me.activemq.demo.domain.model.email.EmailObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by _liwenhe on 2015/2/28.
 */
public class DemoMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/resources/spring.xml");
        Publisher publisher = (Publisher) context.getBean("publisher");
        Consumer consumer = (Consumer) context.getBean("consumer");



//        long s = System.currentTimeMillis();
//        new Thread(new SendRunnable("sender1", publisher)).start();
//        new Thread(new SendRunnable("sender2", publisher)).start();
//        new Thread(new SendRunnable("sender3", publisher)).start();
//        new Thread(new SendRunnable("sender4", publisher)).start();
//        new Thread(new SendRunnable("sender5", publisher)).start();
//        new Thread(new SendRunnable("sender6", publisher)).start();
//        new Thread(new SendRunnable("sender7", publisher)).start();
//        new Thread(new SendRunnable("sender8", publisher)).start();
//        new Thread(new SendRunnable("sender9", publisher)).start();
//        new Thread(new SendRunnable("sender10", publisher)).start();
//        new Thread(new ConsumerRunnable(consumer));
//        new Thread(new ConsumerRunnable(consumer));
//        new Thread(new ConsumerRunnable(consumer));
//        new Thread(new ConsumerRunnable(consumer));
//        new Thread(new ConsumerRunnable(consumer));
//        System.out.println(System.currentTimeMillis() -s);
//        consumer.receive("2");
        while(true) {
                    consumer.receive("2");
        }
//        consumer.size("2");
    }
}
