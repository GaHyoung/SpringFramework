package com.nhnacademy.edu.springframework.greeting.annotaion;

import com.nhnacademy.edu.springframework.greeting.Language;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
//@Qualifier  <-- 주석처리를 해도 bean.xml의 CustomAutowireConfigurer 때문에 동작합니다.
public @interface GreeterQualifier {
    Language language();
    boolean dummy();
}