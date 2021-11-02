package com.task.taskexecutor.executor;

import com.task.taskexecutor.pojo.TaskContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskExecutorService {

    private final TaskSequenceManager taskSequenceManager;

    public TaskExecutorService(TaskSequenceManager taskSequenceManager){
        this.taskSequenceManager = taskSequenceManager;
    }

    public void executeTaskSequence(List<String> taskSequences, TaskContext taskContext){
        taskSequenceManager.executeTaskSequence(taskSequences, taskContext);
    }
}
