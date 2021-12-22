package ru.otus.trim.service;

import org.springframework.stereotype.Service;
import ru.otus.trim.domain.Student;

import java.util.Scanner;


public class StudentRequestServiceByInput implements StudentRequestService{

    @Override
    public Student requestStudent() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scaner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scaner.nextLine();
        return new Student(firstName, lastName);
    }
}
