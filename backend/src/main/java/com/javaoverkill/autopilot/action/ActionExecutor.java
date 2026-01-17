package com.javaoverkill.autopilot.action;
import com.javaoverkill.autopilot.action.Action;

public interface ActionExecutor<T extends Action>{
    Class<T> supports();
    void execute(T action);
}
