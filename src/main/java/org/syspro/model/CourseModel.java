package org.syspro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.syspro.entity.CourseEntity;
import org.syspro.repository.CourseRepos;
import org.syspro.utils.Accord;

import java.util.List;

@Component
public class CourseModel {
    private final CourseRepos courseRepos;
    private final Accord accord;

    @Autowired
    public CourseModel(CourseRepos courseRepos, Accord accord) {
        this.courseRepos = courseRepos;
        this.accord = accord;
    }

    public CourseEntity create(long streamId, long educatorId, String title) {
        return courseRepos.save(new CourseEntity(streamId, educatorId, title));
    }

    public List<CourseEntity> courses(long offset, int count) {
        accord.repositoryGetAllChecker(offset, count);
        return courseRepos.findByIdBetween(offset, offset + count - 1);
    }

    public List<CourseEntity> byEducatorId(long educatorId, long offset, int count) {
        accord.repositoryGetAllChecker(offset, count);
        return courseRepos.findByEducatorIdAndIdBetween(educatorId, offset, offset + count - 1);
    }

    public List<CourseEntity> byStreamId(long streamId, long offset, int count) {
        accord.repositoryGetAllChecker(offset, count);
        return courseRepos.findByStreamIdAndIdBetween(streamId, offset, offset + count - 1);
    }
}
