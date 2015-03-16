package me.activemq.demo.application.queue;

import javax.jms.Message;

/**
 * Created by _liwenhe on 2015/2/28.
 */
public interface IQueueService {

    Boolean push(final String name, final Object message);

    Message pop(final String name);

    Message pop(final String name, final long timeout);

    long size(final String name);

}
