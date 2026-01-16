package com.javaoverkill.autopilot.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;
import java.time.Instant;

@Entity
@Table(name="actions")
public class ActionEntity {
    @Id
    private UUID id;
    private String type;

    @Column(length = 4000)
    private String payload;
    private Instant createdAt;

    protected ActionEntity(){}

    public ActionEntity(UUID id, String type, String payload, Instant createdAt){
        this.id = id;
        this.type = type;
        this.payload = payload;
        this.createdAt = createdAt;
    }
    public UUID getId(){return id;}


}
