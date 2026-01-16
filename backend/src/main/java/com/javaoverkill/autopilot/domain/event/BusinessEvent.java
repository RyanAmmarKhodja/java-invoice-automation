package com.javaoverkill.autopilot.domain.event;

import java.util.UUID;
import java.time.Instant;


public abstract class BusinessEvent {
    private final UUID id;
    private final Instant occurredAt;

    protected BusinessEvent(){
        this.id = UUID.randomUUID();
        this.occurredAt = Instant.now();
    }

    public UUID getId(){
        return id;
    }

    public Instant getOccurredAt(){
        return occurredAt;
    }

    public abstract EventType getType();
}
