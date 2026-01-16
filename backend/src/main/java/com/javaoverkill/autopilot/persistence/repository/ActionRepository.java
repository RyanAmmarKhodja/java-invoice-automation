package com.javaoverkill.autopilot.persistence.repository;


import com.javaoverkill.autopilot.persistence.entity.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActionRepository extends JpaRepository<ActionEntity, UUID> {

}
