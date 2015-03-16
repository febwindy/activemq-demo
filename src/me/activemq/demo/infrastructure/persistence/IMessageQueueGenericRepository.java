package me.activemq.demo.infrastructure.persistence;

import javax.jms.Message;

/**
 * Created by _liwenhe on 2015/2/28.
 */
public interface IMessageQueueGenericRepository<T> {

    Boolean push(final String name, final T message);

    Message pop(final String name);

    Message pop(final String name, final long timeout);

    long size(final String name);

}
