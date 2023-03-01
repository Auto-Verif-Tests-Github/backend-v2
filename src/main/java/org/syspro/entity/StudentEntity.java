package org.syspro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long streamId;
    private String fullName, githubNickname;

    public StudentEntity() {
    }

    public StudentEntity(long streamId, String fullName, String githubNickname) {
        this.streamId = streamId;
        this.fullName = fullName;
        this.githubNickname = githubNickname;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGithubNickname() {
        return githubNickname;
    }

    public void setGithubNickname(String githubNickname) {
        this.githubNickname = githubNickname;
    }
}
