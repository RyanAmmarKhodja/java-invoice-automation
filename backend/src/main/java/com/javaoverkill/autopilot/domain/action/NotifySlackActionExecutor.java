package com.javaoverkill.autopilot.domain.action;

import org.springframework.stereotype.Component;
import com.javaoverkill.autopilot.action.ActionExecutor;

@Component
public class NotifySlackActionExecutor implements ActionExecutor<NotifySlackAction>{
    @Override
    public Class<NotifySlackAction> supports(){
        return NotifySlackAction.class;
    }

    @Override
    public void execute(NotifySlackAction action){
        System.out.println("[SLACK] #"+action.getChannel()+" -> "+action.getMessage());
    }
}
