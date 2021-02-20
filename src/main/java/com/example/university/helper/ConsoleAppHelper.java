package com.example.university.helper;

import com.example.university.controller.ConsoleAppController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConsoleAppHelper {

    @Autowired
    private ConsoleAppController consoleAppController;

    public static void firstMenu() {
        System.out.println("|----------------------------------|");
        System.out.println("|---------- university ------------|");
        System.out.println("|----------------------------------|");
        System.out.println("|1. show head of department        |");
        System.out.println("|2. show department stat           |");
        System.out.println("|3. show department avg salary     |");
        System.out.println("|4. show count of employee         |");
        System.out.println("|5. global search lectors by names |");
        System.out.println("|----------------------------------|");
        System.out.print("Select a number:");
    }

    public static String getDepartmentName(){
        System.out.print("Put department name:");
        Scanner scanner = new Scanner(System.in);
        String departmentName = scanner.next();

        return departmentName;
    }

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}
