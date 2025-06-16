package com.bonggu.study.springcoreprinciple.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; // 상태를 유지하는 메서드
    }

    public int getPrice() {
        return price; // 상태를 반환하는 메서드
    }
}
