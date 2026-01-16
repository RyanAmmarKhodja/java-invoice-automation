package com.javaoverkill.autopilot.domain.action;

import com.javaoverkill.autopilot.action.Action;
import com.javaoverkill.autopilot.action.ActionType;

public class NotifySlackAction extends Action {
    private final String channel;
    private final String message;

    public NotifySlackAction(String channel, String message){
        super();
        this.channel = channel;
        this.message = message;
    }

    public String getChannel() {
        return channel;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public ActionType getType() {
        return ActionType.NOTIFY_SLACK;
    }
}
