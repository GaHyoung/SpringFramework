package com.nhnacademy.edu.springframework.greeting.factorymethod;

import com.nhnacademy.edu.springframework.greeting.factorymethod.CsvApplication;
import com.nhnacademy.edu.springframework.greeting.factorymethod.framework.Application;

public class Main {
    public static void main(String[] args) {
        Application csvApplication = new CsvApplication();
        csvApplication.openDocument();

//        Application jsonApplication = new JsonApplication();
//        jsonApplication.openDocument();
    }
}