package com.javaoverkill.autopilot.persistence.repository;

import com.javaoverkill.autopilot.persistence.entity.BusinessEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusinessEventRepository
    extends JpaRepository<BusinessEventEntity, UUID>{}

