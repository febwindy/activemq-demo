package me.activemq.demo.application.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import java.io.Serializable;

/**
 * Created by _liwenhe on 2015/2/28.
 */
@Service("queueService")
public class QueueService implements IQueueService {

    @Autowired
    private IActiveMqRepository activeMqRepository;

    @Override
    public Boolean push(String name, Object message) {
        return activeMqRepository.push(name, message);
    }

    @Override
    public Message pop(String name) {
        return activeMqRepository.pop(name);
    }

    @Override
    public Message pop(String name, long timeout) {
        return activeMqRepository.pop(name, timeout);
    }

    @Override
    public long size(String name) {
        return activeMqRepository.size(name);
    }
}
