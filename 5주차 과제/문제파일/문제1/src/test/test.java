package test;

import java.util.*;

class Circle {
    protected int radius;
    public Circle(int r) {
        this.radius = r;
    }
}

class Pizza extends Circle {
    private String pizzaType;

    public Pizza(String t, int r) {
        super(r);
        this.pizzaType = t;
    }

    public void print() {
        System.out.println("피자의 종류: " + this.pizzaType);
        System.out.println("피자의 크기: " + this.radius);
    }
}

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pizza obj = new Pizza("Peppperoni", 20);
        obj.print();

    }
}