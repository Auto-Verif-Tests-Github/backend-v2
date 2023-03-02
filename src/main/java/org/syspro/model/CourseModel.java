package org.syspro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.syspro.entity.CourseEntity;
import org.syspro.repository.CourseRepos;

import java.util.List;

@Component
public class CourseModel {
    private final CourseRepos courseRepos;

    @Autowired
    public CourseModel(CourseRepos courseRepos) {
        this.courseRepos = courseRepos;
    }

    public CourseEntity create(long streamId, long educatorId, String title) {
        return courseRepos.save(new CourseEntity(streamId, educatorId, title));
    }

    public List<CourseEntity> courses(Pageable pageable) {
        return courseRepos.findAll(pageable).getContent();
    }

    public List<CourseEntity> byEducatorId(long educatorId, Pageable pageable) {
        return courseRepos.findByEducatorId(educatorId, pageable).getContent();
    }

    public List<CourseEntity> byStreamId(long streamId, Pageable pageable) {
        return courseRepos.findByStreamId(streamId, pageable).getContent();
    }
}
