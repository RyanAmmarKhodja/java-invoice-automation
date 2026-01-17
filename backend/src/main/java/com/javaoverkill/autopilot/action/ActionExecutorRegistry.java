package com.javaoverkill.autopilot.action;

import com.javaoverkill.autopilot.action.Action;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ActionExecutorRegistry {

    private final Map<Class<? extends Action>, ActionExecutor<?>> executors
            = new HashMap<>();

    public ActionExecutorRegistry(List<ActionExecutor<?>> executorsList) {

        for (ActionExecutor<?> executor : executorsList) {
            executors.put(executor.supports(), executor);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Action> ActionExecutor<T> getExecutor(T action) {

        ActionExecutor<T> executor =
                (ActionExecutor<T>) executors.get(action.getClass());

        if (executor == null) {
            throw new IllegalStateException(
                    "No executor found for action " + action.getClass().getSimpleName()
            );
        }

        return executor;
    }
}
