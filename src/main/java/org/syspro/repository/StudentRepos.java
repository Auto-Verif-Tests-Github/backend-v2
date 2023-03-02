package org.syspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentRepos extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findByIdBetween(long startId, long stopId);
    List<StudentEntity> findByStreamId(long streamId);
    Optional<StudentEntity> findByGithubNickname(String githubNickname);
}
