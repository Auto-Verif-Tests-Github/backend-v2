package org.syspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.StreamEntity;

import java.util.List;

public interface StreamRepos extends JpaRepository<StreamEntity, Long> {
    List<StreamEntity> findByIdBetween(long startId, long stopId);
    List<StreamEntity> findByTitle(String title);
}
