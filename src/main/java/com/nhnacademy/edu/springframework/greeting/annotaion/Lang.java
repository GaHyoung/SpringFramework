package com.nhnacademy.edu.springframework.greeting.annotaion;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Lang { //직접 @Qualifier 를 대신하는 어노테이션 만들어보기.
//    String value();
    //value 없는 Annotation 을 생성하여 Annotation 을 설정하는 것 만으로도 처리를 할 수 있다.
}
