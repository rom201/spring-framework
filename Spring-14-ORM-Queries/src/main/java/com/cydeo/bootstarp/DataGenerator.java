package com.cydeo.bootstarp;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;


    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------Region start---------------");
        System.out.println(regionRepository.findByCountry("Canada"));
        System.out.println(regionRepository.findDistinctByCountry("United States"));
        System.out.println(regionRepository.findByCountryContaining("United"));
        System.out.println(regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println(regionRepository.findByCountryContainingOrderByRegionDesc("Asia"));
        System.out.println(regionRepository.findTop2ByCountry("United States"));

        System.out.println("---------Region finish---------------");

        System.out.println("---------Department start---------------");
        System.out.println(departmentRepository.findByDepartment("Furniture"));
        System.out.println(departmentRepository.findByDivisionIs("Electronics"));
        System.out.println(departmentRepository.findByDivisionEquals("Kids"));
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("---------Department finish---------------");



        System.out.println("---------Employee start---------------");

        System.out.println(employeeRepository.findByEmail("ssymonds2@hhs.gov"));
        System.out.println(employeeRepository.findByFirstNameAndLastNameOrEmail("Bethena","Trow","ssymonds2@hhs.gov"));
        System.out.println(employeeRepository.findByLastNameStartsWith("Ann"));

        System.out.println("---------Employee start JPQL---------------");
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());



        System.out.println("---------Employee finish---------------");



    }
}
