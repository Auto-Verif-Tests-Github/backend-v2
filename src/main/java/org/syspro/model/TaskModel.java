package org.syspro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.syspro.entity.TaskEntity;
import org.syspro.repository.TaskRepos;
import org.syspro.utils.Accord;

import java.util.List;

@Component
public class TaskModel {
    private final TaskRepos taskRepos;
    private final Accord accord;

    @Autowired
    public TaskModel(TaskRepos taskRepos, Accord accord) {
        this.taskRepos = taskRepos;
        this.accord = accord;
    }

    public TaskEntity create(long courseId, long streamId, long dateUNIX, long dateUNIXDeadline, String title) {
        accord.paramsDateUNIXCheck(dateUNIX, dateUNIXDeadline);
        return taskRepos.save(new TaskEntity(courseId, streamId, dateUNIX, dateUNIXDeadline, title));
    }

    public List<TaskEntity> tasks(Pageable pageable) {
        return taskRepos.findByIdBetween(pageable).getContent();
    }

    public List<TaskEntity> byCourseId(long courseId, Pageable pageable) {
        return taskRepos.findByCourseId(courseId, pageable).getContent();
    }
}
