package com.javaoverkill.autopilot.action;

import java.time.Instant;
import java.util.UUID;

public abstract class Action {
    private final UUID id;
    private final Instant createdAt;

    protected Action() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

    public UUID getId(){
        return id;
    }

    public Instant getCreatedAt(){
        return createdAt;
    }

    public abstract ActionType getType();

}
