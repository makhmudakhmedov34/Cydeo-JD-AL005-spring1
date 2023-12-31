package com.cydeo.bootstrap;

import com.cydeo.entity.Employee;
import com.cydeo.repository.CoursesRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CoursesRepository coursesRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CoursesRepository coursesRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.coursesRepository = coursesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("----------------Region Start----------------");

        System.out.println("regionRepository.findByCountry(\"United States\") = " + regionRepository.findByCountry("United States"));
        System.out.println("regionRepository.findDistinctByCountry(\"United States\") = " + regionRepository.findDistinctByCountry("United States"));
        System.out.println("regionRepository.findByCountryContaining(\"Canada\") = " + regionRepository.findByCountryContaining("Canada"));
        System.out.println("regionRepository.findByCountryContainingOrderByCountry(\"Canada\") = " + regionRepository.findByCountryContainingOrderByCountry("Canada"));
        System.out.println("regionRepository.findTopTwoByCountry(\"Canada\") = " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("----------------Region End----------------");

        System.out.println("----------------Department Start----------------");

        System.out.println("findByDepartment "+departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivisionIs "+departmentRepository.findByDivisionIs("Health"));
        System.out.println("findDistinctTop3ByDivisionContainsName "+departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("----------------Department End----------------");


        System.out.println("----------------Employee Start----------------");

        System.out.println("getEmployeeDetail: "+employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: "+employeeRepository.getEmployeeSalary());
        System.out.println("----------------Employee End----------------");


        System.out.println("----------------Courses Start----------------");

        coursesRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println();
        coursesRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println();
        System.out.println(coursesRepository.existsByName("JavaScript for All"));
        System.out.println();
        System.out.println(coursesRepository.countByCategory("Spring"));
        System.out.println();
        coursesRepository.findByNameStartsWith("Scalable").forEach(System.out::println);
        System.out.println();
        coursesRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("----------------Courses End----------------");


    }
}
