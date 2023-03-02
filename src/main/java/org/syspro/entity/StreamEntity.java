package org.syspro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "streams")
public class StreamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @JsonProperty("classroom_link")
    private String classroomLink;

    public StreamEntity() {
    }

    public StreamEntity(String title, String classroomLink) {
        this.title = title;
        this.classroomLink = classroomLink;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassroomLink() {
        return classroomLink;
    }

    public void setClassroomLink(String classroomLink) {
        this.classroomLink = classroomLink;
    }
}
