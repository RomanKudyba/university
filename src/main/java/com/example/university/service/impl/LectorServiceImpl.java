package com.example.university.service.impl;

import com.example.university.dto.DegreeCount;
import com.example.university.model.Degree;
import com.example.university.model.Department;
import com.example.university.model.Lector;
import com.example.university.repo.LectorRepo;
import com.example.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorServiceImpl implements LectorService {

    @Autowired
    private LectorRepo lectorRepo;

    @Override
    public Lector getDepartmentHeadByDepartment(Department department) {
        List<Long> lectorIds = lectorRepo.getLectorIdsByDepartment(department.getId());
        Lector departmentHead = lectorRepo.getDepartmentHeadByDepartment(lectorIds, Degree.head_of_department);
        return departmentHead;
    }

    @Override
    public List<DegreeCount> getStatisticCountsDegree(Department department) {
        List<Long> lectorIds = lectorRepo.getLectorIdsByDepartment(department.getId());
        List<DegreeCount> degreeCounts = lectorRepo.getStatisticCounts(lectorIds);
        return degreeCounts;
    }

    @Override
    public Double getAvgSalaryByDepartment(Department department) {
        Double avgSalaryByDepartment = lectorRepo.getAvgSalaryByDepartment(department.getId());
        return avgSalaryByDepartment;
    }

    @Override
    public Long getCountEmployeesByDepartment(Department department) {
        Long countEmployees = lectorRepo.getCountEmployeesByDepartment(department.getId());
        return countEmployees;
    }

    @Override
    public List<Lector> globalSearch(String template) {
        List<Lector> lectors = lectorRepo.globalSearch(template);
        return lectors;
    }
}
