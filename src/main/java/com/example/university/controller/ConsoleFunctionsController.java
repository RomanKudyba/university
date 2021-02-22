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

    private DepartmentService departmentService;
    private LectorService lectorService;

    @Autowired
    ConsoleFunctionsController(DepartmentService departmentService, LectorService lectorService){
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public void showHeadOfDepartment(){
        Department department = getDepartmentByName();
        if (validateDepartment(department)){
            Lector lector = lectorService.getDepartmentHeadByDepartment(department);
            if (lector != null){
                System.out.println("Head of " + department.getName() + " department is " + lector.toString());
            } else{
                notFount();
            }
        }
    }

    public void showDegreeCountStats(){
        Department department = getDepartmentByName();
        if (validateDepartment(department)){
            List<DegreeCount> statistic = lectorService.getStatisticCountsDegree(department);
            if (statistic.size() == 0){
                notFount();
            } else{
                System.out.println(statistic.toString());
            }
        }

    }

    public void showAverageSalaryOfDepartment(){
        Department department = getDepartmentByName();
        if (validateDepartment(department)){
            Double avgSalaryForDepartment = lectorService.getAvgSalaryByDepartment(department);
            if (avgSalaryForDepartment == null){
                notFount();
            } else{
                System.out.println("The average salary of " + department.getName() + " is " + avgSalaryForDepartment);
            }
        }
    }

    public void showCountEmployeesOfDepartment(){
        Department department = getDepartmentByName();
        if (validateDepartment(department)){
            Long countEmployees = lectorService.getCountEmployeesByDepartment(department);
            if (countEmployees == null){
                notFount();
            } else{
                System.out.println(countEmployees);
            }
        }
    }

    public void globalSearch(){
        System.out.print("Enter str to start global search:");
        Scanner scanner = new Scanner(System.in);
        String template = scanner.next();
        List<Lector> lectors = lectorService.globalSearch(template);
        if (lectors.size() == 0){
            notFount();
        } else{
            System.out.println(lectors.toString());
        }
    }

    private boolean validateDepartment(Department department){
        if (department == null){
            System.out.println("Department not found");
            return false;
        }

        return true;
    }

    private Department getDepartmentByName(){
        String departmentName = ConsoleAppHelper.getDepartmentName();
        Department department = departmentService.getDepartmentByName(departmentName);
        return department;
    }

    private void notFount(){
        System.out.println("Not found");
    }
}
