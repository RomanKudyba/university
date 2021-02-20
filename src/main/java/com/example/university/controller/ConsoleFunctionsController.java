package com.example.university.controller;

import com.example.university.dto.DegreeCount;
import com.example.university.helper.ConsoleAppHelper;
import com.example.university.model.Degree;
import com.example.university.model.Department;
import com.example.university.model.Lector;
import com.example.university.service.DepartmentService;
import com.example.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
public class ConsoleFunctionsController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LectorService lectorService;

    public void globalSearch(){
        System.out.print("Enter str to start global search:");
        Scanner scanner = new Scanner(System.in);
        String template = scanner.next();
        List<Lector> lectors = lectorService.globalSearch(template);
        String lectorsStr = new String();
        for (Lector lector : lectors) {
            lectorsStr += lector.toString() + ", ";
        }
        if (lectorsStr.length() != 0) {
            lectorsStr = lectorsStr.substring(0, lectorsStr.length() -2);
        }
        System.out.println(lectorsStr);
    }

    public void showHeadOfDepartment(){
        String departmentName = ConsoleAppHelper.getDepartmentName();
        Department department = departmentService.getDepartmentByName(departmentName);
        Lector lector = lectorService.getDepartmentHeadByDepartment(department);
        if (lector != null){
            System.out.println("Head of " + departmentName + " department is " + lector.toString());
        }
    }

    public void showDegreeCountStats(){
        String departmentName2 = ConsoleAppHelper.getDepartmentName();
        Department department2 = departmentService.getDepartmentByName(departmentName2);
        List<DegreeCount> statistic = lectorService.getStatisticCountsDegree(department2);

        for (Degree degree : Degree.values()) {
            if (degree.equals(Degree.head_of_department)){
                continue;
            }

            List<DegreeCount> oneDegreeList = statistic.stream().filter(f -> f.getDegree().equals(degree)).collect(Collectors.toList());
            if (oneDegreeList.size() == 0) {
                System.out.println(degree + " - " + 0);
            } else {
                System.out.println(degree + " - " + oneDegreeList.get(0).getCount());
            }
        }
    }

    public void showAverageSalaryOfDepartment(){
        String departmentName3 = ConsoleAppHelper.getDepartmentName();
        Department department3 = departmentService.getDepartmentByName(departmentName3);
        Double avgSalaryForDepartment = lectorService.getAvgSalaryByDepartment(department3);
        System.out.println("The average salary of " + departmentName3 + " is " + avgSalaryForDepartment);
    }

    public void showCountEmployeesOfDepartment(){
        String departmentName4 = ConsoleAppHelper.getDepartmentName();
        Department department4 = departmentService.getDepartmentByName(departmentName4);
        Long countEmployees = lectorService.getCountEmployeesByDepartment(department4);
        System.out.println(countEmployees);
    }
}
