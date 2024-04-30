package com.br.cursos.Ignite.modules.repository;


import com.br.cursos.Ignite.modules.entity.CourseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    Optional<CourseEntity> findByNameAndCategory(String name, String category);

    CourseEntity findByName(String name);

    CourseEntity findByCategory(String category);

}
