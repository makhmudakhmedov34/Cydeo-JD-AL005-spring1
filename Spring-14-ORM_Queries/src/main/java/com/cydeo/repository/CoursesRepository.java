package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CoursesRepository extends JpaRepository<Course,Long> {

    // find all courses find by category
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the provided name exist. return true if course exist,false otherwise
    boolean existsByName(String name);

    // returns the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String name);

    // find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);





}
