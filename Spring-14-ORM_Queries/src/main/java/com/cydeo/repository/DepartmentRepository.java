package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //Display All departments in the furniture department
    List<Department> findByDepartment(String department);

    // Display all Departments in the Health Division
    List<Department> findByDivisionIs(String division);

    List<Department> findByDivisionEquals(String division);

    // Division top 3 department with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String division);



}
