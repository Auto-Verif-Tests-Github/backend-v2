package org.syspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.syspro.entity.CourseEntity;
import org.syspro.model.CourseModel;

import java.util.List;

@RestController
@RequestMapping(value = "${api.start}/courses")
public class CourseController {
    private final CourseModel courseModel;

    @Autowired
    public CourseController(CourseModel courseModel) {
        this.courseModel = courseModel;
    }

    @RequestMapping(value = "/{stream_id}", method = {RequestMethod.GET, RequestMethod.POST})
    private CourseEntity create(@PathVariable(name = "stream_id") long streamId,
                                @RequestParam(name = "educator_id") long educatorId,
                                @RequestParam String title) {
        return courseModel.create(streamId, educatorId, title);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    private List<CourseEntity> courses(Pageable pageable) {
        return courseModel.courses(pageable);
    }

    @RequestMapping(value = "/by.educator.id", method = {RequestMethod.GET, RequestMethod.POST})
    private List<CourseEntity> byEducatorId(@RequestParam(name = "educator_id") long educatorId, Pageable pageable) {
        return courseModel.byEducatorId(educatorId, pageable);
    }

    @RequestMapping(value = "/by.stream.id", method = {RequestMethod.GET, RequestMethod.POST})
    private List<CourseEntity> byStreamId(@RequestParam(name = "stream_id") long streamId, Pageable pageable) {
        return courseModel.byStreamId(streamId, pageable);
    }
}
