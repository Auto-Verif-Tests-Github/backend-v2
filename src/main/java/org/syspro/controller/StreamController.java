package org.syspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.syspro.entity.StreamEntity;
import org.syspro.model.StreamModel;

import java.util.List;

@RestController
@RequestMapping(value = "${api.start}/streams")
public class StreamController {
    private final StreamModel streamModel;

    @Autowired
    public StreamController(StreamModel streamModel) {
        this.streamModel = streamModel;
    }

    @RequestMapping(value = "/{title}", method = {RequestMethod.GET, RequestMethod.POST})
    private StreamEntity create(@PathVariable String title,
                                @RequestParam(name = "classroom_link") String classroomLink) {
        return streamModel.create(title, classroomLink);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    private List<StreamEntity> streams(Pageable pageable) {
        return streamModel.streams(pageable);
    }

    @RequestMapping(value = "/by.title", method = {RequestMethod.GET, RequestMethod.POST})
    private List<StreamEntity> byTitle(@RequestParam String title, Pageable pageable) {
        return streamModel.byTitle(title, pageable);
    }
}
