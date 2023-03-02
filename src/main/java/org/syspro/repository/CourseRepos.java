package org.syspro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.CourseEntity;

public interface CourseRepos extends JpaRepository<CourseEntity, Long> {
    Page<CourseEntity> findByEducatorId(long educatorId, Pageable pageable);
    Page<CourseEntity> findByStreamId(long streamId, Pageable pageable);
}
