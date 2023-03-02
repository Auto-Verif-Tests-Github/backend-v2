package org.syspro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.syspro.entity.StreamEntity;
import org.syspro.repository.StreamRepos;

import java.util.List;

@Component
public class StreamModel {
    private final StreamRepos streamRepos;

    @Autowired
    public StreamModel(StreamRepos streamRepos) {
        this.streamRepos = streamRepos;
    }

    public StreamEntity create(String title, String classroomLink) {
        if(!classroomLink.matches("https://classroom\\.github\\.com/classrooms/.*")) {
            throw new IllegalArgumentException("classroomLink is not link on classroom");
        }
        return streamRepos.save(new StreamEntity(title, classroomLink));
    }

    public List<StreamEntity> streams(Pageable pageable) {
        return streamRepos.findAll(pageable).getContent();
    }

    public List<StreamEntity> byTitle(String title, Pageable pageable) {
        return streamRepos.findByTitle(title, pageable).getContent();
    }
}
