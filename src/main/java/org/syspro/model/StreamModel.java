package org.syspro.model;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<StreamEntity> streams(long offset, int count) {
        if(offset < 1 || count < 2 || count > 200) {
            throw new IllegalArgumentException();
        }
        return streamRepos.findByIdBetween(offset, offset + count - 1);
    }

    public List<StreamEntity> byTitle(String title) {
        return streamRepos.findByTitle(title);
    }
}
