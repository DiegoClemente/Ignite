package com.br.cursos.Ignite.modules.services;


import com.br.cursos.Ignite.modules.entity.CourseEntity;
import com.br.cursos.Ignite.modules.exceptions.CourseNotFound;
import com.br.cursos.Ignite.modules.exceptions.ExceptionWithoutData;
import com.br.cursos.Ignite.modules.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class Course{


    @Autowired
    private CourseRepository courseRepository;


    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository
                .findByNameAndCategory(courseEntity.getName(), courseEntity.getCategory());

        return this.courseRepository.save(courseEntity);
    }

    public CourseEntity getCourseByName(CourseEntity courseEntity) {
        return courseRepository.findByName(courseEntity.getName());
    }

    public CourseEntity getCourseByCategory(CourseEntity courseEntity) {
        return courseRepository.findByCategory(courseEntity.getCategory());
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseEntity updateCourse(UUID id, CourseEntity courseEntity) throws CourseNotFound, ExceptionWithoutData {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFound("Course not found."));

        if (courseEntity.getName() != null && courseEntity.getCategory() == null) {
            course.setName(courseEntity.getName());
        }

        if (courseEntity.getName() == null && courseEntity.getCategory() != null) {
            course.setCategory(courseEntity.getCategory());
        }
        if (courseEntity.getName() != null && courseEntity.getCategory() != null) {
            course.setName(courseEntity.getName());
            course.setCategory(courseEntity.getCategory());
        }
        if (courseEntity.getName() == null && courseEntity.getCategory() == null){
            ExceptionWithoutData.getMessage("To update name or/and category it's necessary set the new values.");
        }

        return courseRepository.save(course);

    }

    public ResponseEntity<Object> deleteCourse(UUID id) throws CourseNotFound {
        var delete = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFound(("Course not found")));

        if (courseRepository.existsById(id)) {
            courseRepository.delete(delete);
            return ResponseEntity.status(200).body(delete);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Object> toggleCourseStatus(UUID id) throws CourseNotFound {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFound("Course not found."));


        boolean newStatus = !course.isActive();
        course.setActive(newStatus);


        courseRepository.save(course);


        return ResponseEntity.ok().body(course);
    }

}
