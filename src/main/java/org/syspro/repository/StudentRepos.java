package org.syspro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.StudentEntity;

import java.util.Optional;

public interface StudentRepos extends JpaRepository<StudentEntity, Long> {
    Page<StudentEntity> findByStreamId(long streamId, Pageable pageable);
    Optional<StudentEntity> findByGithubNickname(String githubNickname);
}
