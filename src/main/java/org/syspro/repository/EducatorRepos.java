package org.syspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.EducatorEntity;

public interface EducatorRepos extends JpaRepository<EducatorEntity, Long> {
}
