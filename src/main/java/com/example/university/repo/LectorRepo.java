package com.example.university.repo;

import com.example.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectorRepo extends JpaRepository<Lector, Long> {

//    @Query("select l from Lector l where firstName like '%?1%' or surname like '%?1%'")
//    List<Lector> findByFirstNameAndSurnameLike(String template1, String template2);

//    List<Lector> findAll();
}
