package com.javaoverkill.autopilot.persistence.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="business_events")
public class BusinessEventEntity {

    @Id
    private UUID id;

    private String type;

    @Column(length = 4000)
    private String payload;
    private Instant occurredAt;

    protected BusinessEventEntity() {}
    public BusinessEventEntity(UUID id, String type, String payload, Instant occurredAt){
        this.id=id;
        this.type = type;
        this.payload = payload;
        this.occurredAt = occurredAt;
    }

    public UUID getId() {return id; }
    public String getType() { return type; }
    public String getPayload() { return payload; }
    public Instant getOccurredAt() { return occurredAt; }

}
