package com.example.university.service;

import com.example.university.dto.DegreeCount;
import com.example.university.model.Department;
import com.example.university.model.Lector;

import java.util.List;

public interface LectorService {

    Lector getDepartmentHeadByDepartment(Department department);

    List<DegreeCount> getStatisticCountsDegree(Department department);

    Double getAvgSalaryByDepartment(Department department);

    Long getCountEmployeesByDepartment(Department department);

    List<Lector> globalSearch(String template);
}
