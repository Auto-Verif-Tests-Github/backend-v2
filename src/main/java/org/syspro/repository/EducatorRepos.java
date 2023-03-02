package org.syspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.EducatorEntity;

import java.util.List;

public interface EducatorRepos extends JpaRepository<EducatorEntity, Long> {
    List<EducatorEntity> findByIdBetween(long startId, long stopId);
}
