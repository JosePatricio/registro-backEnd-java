package com.sukasa.domain.events.domain;

import io.jkratz.mediator.core.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteCreatedDomainEvent implements Event {
    private final int id;
}
