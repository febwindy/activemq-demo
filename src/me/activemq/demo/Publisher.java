package me.activemq.demo;

import me.activemq.demo.application.queue.IQueueService;
import me.activemq.demo.domain.model.email.EmailObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by _liwenhe on 2015/2/28.
 */
@Component
public class Publisher {

    @Autowired
    private IQueueService queueService;

    public void send(String name, EmailObject message) {
        Boolean status = queueService.push(name, message);
        if (status == Boolean.TRUE) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
    }

}
