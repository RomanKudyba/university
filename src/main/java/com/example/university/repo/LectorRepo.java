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

    @Query(value = "Select l from Lector l where l.degree = :degree and l.id in :lectorIds")
    Lector getDepartmentHeadByDepartment(List<Long> lectorIds, Degree degree);

    @Query("SELECT new com.example.university.dto.DegreeCount(l.degree, COUNT(l.id)) "
            + "From Lector l where l.id in :lectorIds Group by l.degree")
    List<DegreeCount> getStatisticCounts(List<Long> lectorIds);

    @Query(value = "Select AVG(l.salary) from lector l join department_lector dl on dl.lector_id = l.id " +
            "join department d on dl.department_id = d.id where d.id = ?1 Group By d.id",
            nativeQuery = true)
    Double getAvgSalaryByDepartment(Long departmentId);

    @Query(value = "Select Count(l.id) from lector l join department_lector dl on dl.lector_id = l.id " +
            "join department d on dl.department_id = d.id where d.id = ?1 Group By d.id",
            nativeQuery = true)
    Long getCountEmployeesByDepartment(Long departmentId);

    @Query("Select l from Lector l where l.firstName like %?1% or l.surname like %?1%")
    List<Lector> globalSearch(String template);

    @Query(value = "Select l.id from lector l join department_lector dl on dl.lector_id = l.id " +
            "where dl.department_id = :departmentId",
            nativeQuery = true)
    List<Long> getLectorIdsByDepartment(Long departmentId);

}
