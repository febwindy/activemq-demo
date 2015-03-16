package me.activemq.demo;

import me.activemq.demo.application.queue.IQueueService;
import me.activemq.demo.domain.model.email.EmailObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import java.io.Serializable;

/**
 * Created by _liwenhe on 2015/2/28.
 */
@Component
public class Consumer {

    @Autowired
    private IQueueService queueService;

    private MessageConverter messageConverter;

    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    public void receive(String name) {
        Message message = queueService.pop(name);

        if (null != message) {
            if (message instanceof ObjectMessage) {
                try {
                    EmailObject emailObject = (EmailObject) messageConverter.fromMessage(message);
                    System.out.println("Data:" + emailObject.getData() + ",QueueName:" + emailObject.getQueueName());
                    System.out.println("接收成功");
                } catch (JMSException e) {
                    System.out.println("接收信息异常");
                }
            }
        } else {
            System.out.println("没有消息啦");
        }
    }

    public void size(String name) {
        long size = queueService.size(name);
        System.out.println(size);
    }

}
