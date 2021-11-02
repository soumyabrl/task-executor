package com.task.taskexecutor.myexecutor;

import com.task.taskexecutor.executor.TaskExecutor;
import com.task.taskexecutor.pojo.TaskContext;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseTaskExecutor implements TaskExecutor<TaskContext> {

    @Override
    public void execute(TaskContext taskContext) {
        String payload = taskContext.getPayload();
        taskContext.setPayload(payload.toUpperCase());
    }

    @Override
    public void rollback(TaskContext taskContext) {

    }
}
