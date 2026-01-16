package com.javaoverkill.autopilot.core;

import com.javaoverkill.autopilot.action.Action;
import com.javaoverkill.autopilot.domain.action.NotifySlackAction;
import com.javaoverkill.autopilot.domain.event.BusinessEvent;
import com.javaoverkill.autopilot.domain.event.EmailReceivedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleDecisionEngine implements DecisionEngine {
    @Override
    public List<Action> decide(BusinessEvent event){
        if(event instanceof EmailReceivedEvent email){
            return handleEmail(email);
        }
        return List.of();
    }

    private List<Action> handleEmail(EmailReceivedEvent email){
        if(email.getSubject().toLowerCase().contains("help") || email.getBody().toLowerCase().contains("problem")) {

        return List.of(
                new NotifySlackAction(
                        "support",
                        "Support email from " + email.getFrom()
                )
        );
        }  return List.of();
    }
}
