package com.nhnacademy.edu.springframework.greeting.factorymethod.framework;

public abstract class Application {
    public void openDocument() {
        // do something
        Document document = createDocument();
        document.open();
        // do something
    }

    // 어떤 Document 를 처리할지 Application 추상 객체에서 결정하지 않음.
    // 구현 객체가 runtime 에 결정된다.(Dependency Injection)
    protected abstract Document createDocument();
}