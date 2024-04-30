package com.br.cursos.Ignite.modules.controllers;


import com.br.cursos.Ignite.modules.entity.CourseEntity;
import com.br.cursos.Ignite.modules.exceptions.CourseNotFound;
import com.br.cursos.Ignite.modules.exceptions.ExceptionWithoutData;
import com.br.cursos.Ignite.modules.services.Course;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private Course course;


    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var result = this.course.execute(courseEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name")
    public ResponseEntity<Object> getCourseByName(@RequestBody CourseEntity courseEntity) {
        var course = this.course.getCourseByName(courseEntity);

        if (course != null) {
            return ResponseEntity.ok().body(course);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category")
    public ResponseEntity<Object> getCourseByCategory(@RequestBody CourseEntity courseEntity) {
        var category = this.course.getCourseByCategory(courseEntity);

        if (category != null) {
            return ResponseEntity.ok().body(category);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<CourseEntity> getAllCourses() {
        return course.getAllCourses();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable UUID id, @RequestBody CourseEntity courseEntity) throws CourseNotFound, ExceptionWithoutData {
       var update = this.course.updateCourse(id, courseEntity);
       return ResponseEntity.ok().body(update);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable UUID id) throws CourseNotFound {
        return course.deleteCourse(id);
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> toggleCourseStatus(@PathVariable UUID id) throws CourseNotFound {
        return course.toggleCourseStatus(id);
    }

}
