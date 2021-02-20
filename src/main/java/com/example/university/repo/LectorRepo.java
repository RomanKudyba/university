package com.example.university.repo;

import com.example.university.dto.DegreeCount;
import com.example.university.model.Degree;
import com.example.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectorRepo extends JpaRepository<Lector, Long> {

    @Query("Select l from Lector l, Department d where d.id = ?1 and l.degree = ?2")
    Lector getDepartmentHeadByDepartment(Long departmentId, Degree degree);

    @Query("SELECT new com.example.university.dto.DegreeCount(l.degree, COUNT(l.id)) "
            + "From Lector l, Department d where d.id = ?1 Group by l.degree")
    List<DegreeCount> getStatisticCounts(Long departmentId);

    @Query("Select AVG(l.salary) from Lector l, Department d where d.id = ?1 Group By d.id")
    Double getAvgSalaryByDepartment(Long departmentId);

    @Query("Select Count(l.id) from Lector l, Department d where d.id = ?1 Group By d.id")
    Long getCountEmployeesByDepartment(Long departmentId);

    @Query("Select l from Lector l where l.firstName like %?1% or l.surname like %?1%")
    List<Lector> globalSearch(String template);

}
