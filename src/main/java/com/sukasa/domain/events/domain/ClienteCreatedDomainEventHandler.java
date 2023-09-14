package com.sukasa.domain.events.domain;

import io.jkratz.mediator.core.EventHandler;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class ClienteCreatedDomainEventHandler implements EventHandler<ClienteCreatedDomainEvent> {
    private final static Logger logger = LoggerFactory.getLogger(ClienteCreatedDomainEventHandler.class);

    @Override
    public void handle( ClienteCreatedDomainEvent event) {
        logger.info("Un cliente ha sido registrado " + event.getId());

    }
}
