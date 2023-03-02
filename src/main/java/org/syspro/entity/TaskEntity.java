package org.syspro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty("course_id")
    private long courseId;
    @JsonProperty("stream_id")
    private long streamId;
    @Column(name = "date_created")
    private long date;
    @JsonProperty("date_deadline")
    private long dateDeadline;
    private String title;

    public TaskEntity() {
    }

    public TaskEntity(long courseId, long streamId, long date, long dateDeadline, String title) {
        this.courseId = courseId;
        this.streamId = streamId;
        this.date = date;
        this.dateDeadline = dateDeadline;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStreamId() {
        return streamId;
    }

    public void setStreamId(long streamId) {
        this.streamId = streamId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDateDeadline() {
        return dateDeadline;
    }

    public void setDateDeadline(long dateDeadline) {
        this.dateDeadline = dateDeadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
