package com.example.university.controller;

import com.example.university.helper.ConsoleAppHelper;
import com.example.university.model.Department;
import com.example.university.model.Lector;
import com.example.university.service.DepartmentService;
import com.example.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class ConsoleAppController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LectorService lectorService;

    public void run () {
        ConsoleAppHelper.firstMenu();

        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();

        switch (number) {
            case  ("1"):

                break;
            case  ("2"):
                break;
            case  ("3"):
                break;
            case  ("4"):
                break;
            case  ("5"):
                globalSearch();
                break;
            case  ("0"):
                System.out.println("See you next time");
                break;
            default:
                run();
                break;
        }

    }

    private void globalSearch(){
        System.out.print("Enter str to start global search:");
        Scanner scanner = new Scanner(System.in);
        String template = scanner.next();

//        List<Lector> lectors = lectorService.globalSearch(template, template);
        List<Lector> lectors = lectorService.listAll();

        System.out.println("fasas");

    }
}
