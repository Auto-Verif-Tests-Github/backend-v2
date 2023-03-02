package org.syspro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty("stream_id")
    private long streamId;
    @JsonProperty("educator_id")
    private long educatorId;
    private String title;

    public CourseEntity() {
    }

    public CourseEntity(long streamId, long educatorId, String title) {
        this.streamId = streamId;
        this.educatorId = educatorId;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public long getStreamId() {
        return streamId;
    }

    public void setStreamId(long streamId) {
        this.streamId = streamId;
    }

    public long getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(long educatorId) {
        this.educatorId = educatorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
