package org.syspro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.TaskEntity;

public interface TaskRepos extends JpaRepository<TaskEntity, Long> {
    Page<TaskEntity> findByCourseId(long courseId, Pageable pageable);
}
