package com.javaoverkill.autopilot.action;

import com.javaoverkill.autopilot.action.ActionExecutor;
import com.javaoverkill.autopilot.action.Action;
import com.javaoverkill.autopilot.domain.action.NotifySlackAction;
import com.javaoverkill.autopilot.persistence.mapper.ActionMapper;
import com.javaoverkill.autopilot.persistence.repository.ActionRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionExecutionService {

    private final ActionExecutorRegistry registry;
    private final ActionRepository actionRepository;
    private final ActionMapper actionMapper;

    public ActionExecutionService(
            ActionExecutorRegistry registry,
            ActionRepository actionRepository,
            ActionMapper actionMapper
    ) {
        this.registry = registry;
        this.actionRepository = actionRepository;
        this.actionMapper = actionMapper;
    }

    @Async
    public void execute(List<Action> actions) {

        for (Action action : actions) {

            actionRepository.save(actionMapper.toEntity(action));

            var executor = registry.getExecutor(action);
            executor.execute(action);
        }
    }
}

