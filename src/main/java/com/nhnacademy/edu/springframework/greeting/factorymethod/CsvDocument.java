package com.nhnacademy.edu.springframework.greeting.factorymethod;
import com.nhnacademy.edu.springframework.greeting.factorymethod.framework.Document;

public class CsvDocument extends Document {
    @Override
    public void open() {
        System.out.println("csvDocument opened");
    }
}