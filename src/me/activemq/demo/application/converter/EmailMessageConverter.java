package me.activemq.demo.application.converter;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Created by _liwenhe on 2015/2/28.
 */
public class EmailMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        return session.createObjectMessage((Serializable) o);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        ObjectMessage objMessage = (ObjectMessage) message;
        return objMessage.getObject();
    }
}
