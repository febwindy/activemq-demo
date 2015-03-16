package me.activemq.demo.infrastructure.persistence.activemq;

import me.activemq.demo.application.queue.IActiveMqRepository;
import me.activemq.demo.infrastructure.persistence.AbstractMessageQueueGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by _liwenhe on 2015/2/28.
 */
@Repository("activeMqRepository")
public class ActiveMqRepository extends AbstractMessageQueueGenericRepository<String> implements IActiveMqRepository<String> {
}
