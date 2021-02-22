package com.example.university.repo;

import com.example.university.dto.DegreeCount;
import com.example.university.model.Degree;
import com.example.university.model.Department;
import com.example.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface LectorRepo extends JpaRepository<Lector, Long> {

    @Query(value = "Select l from Lector l join l.department d where l.headOfDepartment = 1 and d.id = :departmentId")
    Lector getDepartmentHeadByDepartment(Long departmentId);

    @Query("SELECT new com.example.university.dto.DegreeCount(l.degree, COUNT(l.id)) "
            + "From Lector l join l.department d where d.id = :departmentId Group by l.degree")
    List<DegreeCount> getStatisticCounts(Long departmentId);


    @Query(value = "Select AVG(l.salary) from Lector l join l.department d where d.id = ?1 Group By d.id")
    Double getAvgSalaryByDepartment(Long departmentId);

    @Query(value = "Select Count(l.id) from Lector l join l.department d where d.id = ?1 Group By d.id")
    Long getCountEmployeesByDepartment(Long departmentId);

    @Query("Select l from Lector l where l.firstName like %?1% or l.surname like %?1%")
    List<Lector> globalSearch(String template);

}
