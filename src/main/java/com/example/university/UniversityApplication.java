package com.example.university;

import com.example.university.controller.ConsoleAppController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsoleAppController consoleAppController = new ConsoleAppController();
		consoleAppController.run();
	}
}
