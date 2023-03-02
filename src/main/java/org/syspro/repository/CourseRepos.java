package org.syspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.CourseEntity;

import java.util.List;

public interface CourseRepos extends JpaRepository<CourseEntity, Long> {
    List<CourseEntity> findByIdBetween(long startId, long stopId);
    List<CourseEntity> findByEducatorIdAndIdBetween(long educatorId, long startId, long stopId);
    List<CourseEntity> findByStreamIdAndIdBetween(long streamId, long startId, long stopId);
}
