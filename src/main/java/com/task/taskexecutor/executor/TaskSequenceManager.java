package com.task.taskexecutor.executor;

import com.task.taskexecutor.exception.TaskSequenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TaskSequenceManager<T> {

    private final ApplicationContext applicationContext;

    public TaskSequenceManager(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public void executeTaskSequence(List<String> taskSequences, T t){

        Map<String,TaskExecutor> beans = this.applicationContext.getBeansOfType(TaskExecutor.class);
        List<TaskExecutor> executedTasks = new ArrayList<>();

        taskSequences.forEach(task -> {
            TaskExecutor currentTaskExecutor = null;
            try{
                currentTaskExecutor = beans.get(task);
                currentTaskExecutor.execute(t);
                executedTasks.add(currentTaskExecutor);
            }catch(Exception e){
                executedTasks.forEach(executedTask-> executedTask.rollback(t));
                throw new TaskSequenceException("Task executor failed and rollback successfully executed for tasks " + executedTasks.toString());
            }
        });
    }
}
