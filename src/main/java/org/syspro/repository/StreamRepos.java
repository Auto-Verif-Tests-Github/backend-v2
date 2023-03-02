package org.syspro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.StreamEntity;

public interface StreamRepos extends JpaRepository<StreamEntity, Long> {
    Page<StreamEntity> findByTitle(String title, Pageable pageable);
}
