package com.javaoverkill.autopilot.persistence.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaoverkill.autopilot.persistence.entity.BusinessEventEntity;
import com.javaoverkill.autopilot.domain.event.BusinessEvent;
import org.springframework.stereotype.Component;

@Component
public class BusinessEventMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public BusinessEventEntity toEntity(BusinessEvent event){
        try{
            String payload = objectMapper.writeValueAsString(event);
            return new BusinessEventEntity(
                    event.getId(),
                    event.getType().name(),
                    payload,
                    event.getOccurredAt()
            );
        } catch (Exception e){
            throw new RuntimeException("Failed to serialize event", e);

        }
    }
}
