package com.javaoverkill.autopilot.action;

import com.javaoverkill.autopilot.domain.action.NotifySlackAction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionDispatcher {
    private final ActionExecutor<NotifySlackAction> notifySlackExecutor;

    public ActionDispatcher(
            ActionExecutor<NotifySlackAction> notifySlackExecutor
    ){
        this.notifySlackExecutor = notifySlackExecutor;
    }

    public void dispatch(List<Action> actions){
        for (Action action : actions){
            if (action instanceof NotifySlackAction slackAction){
                notifySlackExecutor.execute(slackAction);
            }
        }
    }
}
