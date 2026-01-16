package com.javaoverkill.autopilot.api;

import com.javaoverkill.autopilot.action.ActionDispatcher;
import com.javaoverkill.autopilot.core.DecisionEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaoverkill.autopilot.domain.event.EmailReceivedEvent;

@RestController
public class EventController {

    private final DecisionEngine decisionEngine;
    private final ActionDispatcher actionDispatcher;

    public EventController(
            DecisionEngine decisionEngine,
            ActionDispatcher actionDispatcher
    ){
        this.decisionEngine = decisionEngine;
        this.actionDispatcher = actionDispatcher;
    }

    @GetMapping("/")
    public String health(){
        return "AUTOPILOT UP";
    }

    @GetMapping("/test-event")
    public String testEvent(){
        var event = new EmailReceivedEvent(
                "client@test.com",
                "Need help",
                "My invoice is wrong"
        );
        return event.getType()+" at "+event.getOccurredAt();
    }

    @GetMapping("/simulate-email")
    public String simulateEmail(DecisionEngine decisionEngine){
        var event = new EmailReceivedEvent("client@test.com","Need help ASAP", "I have a problem with my invoice");

        var actions = decisionEngine.decide(event);
        actionDispatcher.dispatch(actions);

        return "Actions executed: "+actions.size();

    }
}
