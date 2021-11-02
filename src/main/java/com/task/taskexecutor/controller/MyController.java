package com.task.taskexecutor.controller;

import com.task.taskexecutor.pojo.TaskContext;
import com.task.taskexecutor.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping(value = "/data/{input}", method = RequestMethod.GET)
    public String updateData(@PathVariable String input){
        TaskContext taskContext = new TaskContext();
        taskContext.setPayload(input);
        taskContext.setEndTime(LocalDateTime.now());
        return myService.updateInputData(taskContext);
    }

}
