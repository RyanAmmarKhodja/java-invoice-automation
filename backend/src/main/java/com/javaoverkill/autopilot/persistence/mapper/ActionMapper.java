package com.javaoverkill.autopilot.persistence.mapper;

import com.javaoverkill.autopilot.action.Action;
import com.javaoverkill.autopilot.persistence.entity.ActionEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ActionMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ActionEntity toEntity(Action action) {
        try {
            return new ActionEntity(
                    action.getId(),
                    action.getType().name(),
                    objectMapper.writeValueAsString(action),
                    action.getCreatedAt()
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize action", e);
        }
    }
}
