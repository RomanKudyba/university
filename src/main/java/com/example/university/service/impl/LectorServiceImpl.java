package com.example.university.service.impl;

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

//    @Override
//    public List<Lector> globalSearch(String template1, String template2){
//        return lectorRepo.findByFirstNameAndSurnameLike(template1, template2);
//    }

    @Override
    public List<Lector> listAll(){
        return lectorRepo.findAll();
    }
}
