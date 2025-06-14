package com.bonggu.study.springcoreprinciple.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); // static 영역에 객체를 딱 1개만 생성

    public static SingletonService getInstance() {
        return instance; // public static 메서드를 통해서만 인스턴스에 접근할 수 있다.
    }

    private SingletonService() {} // 생성자를 private으로 선언하여 외부에서 new 키워드를 사용하여 객체를 생성하지 못하도록 한다.

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
