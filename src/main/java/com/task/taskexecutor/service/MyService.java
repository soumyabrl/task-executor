package com.task.taskexecutor.service;

import com.task.taskexecutor.executor.TaskExecutorService;
import com.task.taskexecutor.pojo.TaskContext;
import com.task.taskexecutor.util.TaskSequenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    TaskExecutorService taskExecutorService;

    public String updateInputData(TaskContext taskContext){
        taskExecutorService.executeTaskSequence(TaskSequenceUtil.updateInput(), taskContext);
        return taskContext.getPayload();
    }
}
