package com.example.university.service.impl;

import com.example.university.model.Department;
import com.example.university.repo.DepartmentRepo;
import com.example.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public Department getDepartmentByName(String departmentName) {
        Department department = departmentRepo.findByName(departmentName);
        return department;
    }
}
