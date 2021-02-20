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
        String lectorsStr = new String();
        for (Lector lector : lectors) {
            lectorsStr += lector.toString() + ", ";
        }
        if (lectorsStr.length() != 0) {
            lectorsStr = lectorsStr.substring(0, lectorsStr.length() -2);
        } else {
            lectorsStr += "Lectors didn't found";
        }
        System.out.println(lectorsStr);
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
