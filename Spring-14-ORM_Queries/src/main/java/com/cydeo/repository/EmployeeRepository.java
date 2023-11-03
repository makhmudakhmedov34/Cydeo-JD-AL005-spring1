package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Display all employees with email address ''
    List<Employee> findByEmail(String email);

    // Display all employee with first name '' and last name '', also show all employee with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not
    List<Employee> findByFirstNameIsNot(String firsName);

    //Display all employees where last name starts with
    List<Employee> findByLastNameStartsWith(String lastName);

    //Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all employees with salaries less than equel ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee> findByAndHireDateBetween(LocalDate startDate,LocalDate endDate);

    //Display all employees where salaries greater than and equal to '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employee that do not have email address
    List<Employee> findByEmailIsNull();

    //@Query("select e from Employee e where e.email ='sdubber7@t-online.de'")
   // Employee getEmployeeDetail();

    @Query("SELECT e FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email,int salary);

}
