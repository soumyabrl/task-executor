package com.task.taskexecutor.executor;

public interface TaskExecutor<T> {
    void execute(T t);
    void rollback(T t);
}
