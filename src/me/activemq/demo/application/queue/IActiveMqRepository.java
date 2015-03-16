package me.activemq.demo.application.queue;

import me.activemq.demo.infrastructure.persistence.IMessageQueueGenericRepository;

import java.io.Serializable;

/**
 * Created by _liwenhe on 2015/2/28.
 */
public interface IActiveMqRepository<T extends Serializable> extends IMessageQueueGenericRepository<T> {
}
