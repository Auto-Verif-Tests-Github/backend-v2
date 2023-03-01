package org.syspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syspro.entity.StudentEntity;

public interface StudentRepos extends JpaRepository<StudentEntity, Long> { }
