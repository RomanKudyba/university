package com.example.university.controller;

import com.example.university.helper.ConsoleAppHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConsoleAppController implements CommandLineRunner{

    @Autowired
    private ConsoleFunctionsController consoleFunctionsController;

    @Override
    public void run(String... args) {
        ConsoleAppHelper.firstMenu();

        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();

        switch (number) {
            case  ("1"):
                consoleFunctionsController.showHeadOfDepartment();
                break;
            case  ("2"):
                consoleFunctionsController.showDegreeCountStats();
                break;
            case  ("3"):
                consoleFunctionsController.showAverageSalaryOfDepartment();
                break;
            case  ("4"):
                consoleFunctionsController.showCountEmployeesOfDepartment();
                break;
            case  ("5"):
                consoleFunctionsController.globalSearch();;
                break;
            default:
                run();
                break;
        }
        lastMenu();
    }

    private void lastMenu() {
        System.out.println("0. exit programme");
        System.out.println("9. first menu");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();

        switch (number) {
            case  ("0"):
                System.out.println("See you next time");
                break;
            case  ("9"):
                run();
                break;
            default:
                lastMenu();
                break;
        }
    }

}
