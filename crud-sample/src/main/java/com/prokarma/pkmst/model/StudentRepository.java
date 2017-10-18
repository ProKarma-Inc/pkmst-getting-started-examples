package com.prokarma.pkmst.model;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "student")
public interface StudentRepository extends JpaRepository<Student, Long> {

	Collection<Student> findByEmail(@Param("email") String e);

}
