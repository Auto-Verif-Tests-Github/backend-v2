package org.syspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.syspro.entity.TaskEntity;
import org.syspro.model.TaskModel;

import java.util.List;

@RestController
@RequestMapping(value = "${api.start}/tasks")
public class TaskController {
    private final TaskModel taskModel;

    @Autowired
    public TaskController(TaskModel taskModel) {
        this.taskModel = taskModel;
    }

    @RequestMapping(value = "/{course_id}", method = {RequestMethod.GET, RequestMethod.POST})
    private TaskEntity create(@PathVariable("course_id") long courseId,
                              @RequestParam("stream_id") long streamId,
                              @RequestParam("date") long dateUNIX,
                              @RequestParam("date_deadline") long dateUNIXDeadline,
                              @RequestParam String title) {
        return taskModel.create(courseId, streamId, dateUNIX, dateUNIXDeadline, title);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    private List<TaskEntity> tasks(Pageable pageable) {
        return taskModel.tasks(pageable);
    }

    @RequestMapping(value = "/by.course.id", method = {RequestMethod.GET, RequestMethod.POST})
    private List<TaskEntity> byCourseId(@RequestParam("course_id") long courseId,
                                        Pageable pageable) {
        return taskModel.byCourseId(courseId, pageable);
    }
}
