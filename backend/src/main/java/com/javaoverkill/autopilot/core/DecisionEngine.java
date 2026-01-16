package com.javaoverkill.autopilot.core;

import com.javaoverkill.autopilot.domain.event.BusinessEvent;
import com.javaoverkill.autopilot.action.Action;

import java.util.List;

public interface DecisionEngine {

    List<Action> decide(BusinessEvent event);
}
