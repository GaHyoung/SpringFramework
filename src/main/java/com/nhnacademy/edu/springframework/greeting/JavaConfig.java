package com.nhnacademy.edu.springframework.greeting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig { //Bean 생성

    //spring JavaConfig 클래스는 @Bean 어노테이션을 설정한 메소드로 구성
    @Bean/*(name = "dbms")*/
    public String dbms() {
        return new String("MYSQL");
    }
}