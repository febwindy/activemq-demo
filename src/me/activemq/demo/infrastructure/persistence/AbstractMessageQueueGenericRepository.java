package me.activemq.demo.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Repository;

import javax.jms.*;
import java.io.Serializable;
import java.util.Enumeration;

/**
 * Created by _liwenhe on 2015/2/28.
 */
@Repository
public abstract class AbstractMessageQueueGenericRepository<T extends Serializable> implements IMessageQueueGenericRepository<T> {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public Boolean push(String name, final T message) {
        Boolean status = true;
        try {
            jmsTemplate.send(name, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    ObjectMessage objectMessage = session.createObjectMessage();
                    objectMessage.setObject(message);
                    return objectMessage;
                }
            });
        } catch (JmsException e) {
            status = false;
        }

        return status;
    }

    @Override
    public Message pop(final String name) {
        Message message = jmsTemplate.execute(new SessionCallback<Message>() {
            @Override
            public Message doInJms(Session session) throws JMSException {
                Destination destination = session.createQueue(name);
                MessageConsumer consumer = session.createConsumer(destination);

                Message message = consumer.receive(1000);

                if (null != message) {
                    try {
                        message.acknowledge();
                    } catch (JMSException e) {
                        System.out.println("异常啦");
                    }
                }

                return message;
            }
        }, true);

        return message;
    }

    @Override
    public Message pop(final String name, final long timeout) {
        Message message = jmsTemplate.execute(new SessionCallback<Message>() {
            @Override
            public Message doInJms(Session session) throws JMSException {
                Destination destination = session.createQueue(name);
                MessageConsumer consumer = session.createConsumer(destination);

                Message message = consumer.receive(timeout);

                if (null != message) {
                    try {
                        message.acknowledge();
                    } catch (JMSException e) {
                        System.out.println("异常啦");
                    }
                }

                return message;
            }
        }, true);

        return message;
    }

    @Override
    public long size(final String name) {
        long size = jmsTemplate.execute(new SessionCallback<Long>() {
            @Override
            public Long doInJms(Session session) throws JMSException {
                Long counter = 0L;

                Queue queue = session.createQueue(name);
                QueueBrowser browser = session.createBrowser(queue);

                Enumeration enumeration = browser.getEnumeration();
                while (enumeration.hasMoreElements()) {
                    counter++;
                    enumeration.nextElement();
                }
                return counter;
            }
        }, true);

        return size;
    }
}
