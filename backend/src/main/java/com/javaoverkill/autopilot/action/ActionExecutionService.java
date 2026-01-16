package com.javaoverkill.autopilot.action;

import com.javaoverkill.autopilot.action.ActionExecutor;
import com.javaoverkill.autopilot.action.Action;
import com.javaoverkill.autopilot.domain.action.NotifySlackAction;
import com.javaoverkill.autopilot.persistence.mapper.ActionMapper;
import com.javaoverkill.autopilot.persistence.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionExecutionService {

    private final ActionExecutor<NotifySlackAction> slackExecutor;
    private final ActionRepository actionRepository;
    private final ActionMapper actionMapper;

    public ActionExecutionService(
            ActionExecutor<NotifySlackAction> slackExecutor,
            ActionRepository actionRepository,
            ActionMapper actionMapper
    ) {
        this.slackExecutor = slackExecutor;
        this.actionRepository = actionRepository;
        this.actionMapper = actionMapper;
    }

    public void execute(List<Action> actions) {

        for (Action action : actions) {

            actionRepository.save(actionMapper.toEntity(action));

            if (action instanceof NotifySlackAction slackAction) {
                slackExecutor.execute(slackAction);
            }
        }
    }
}
