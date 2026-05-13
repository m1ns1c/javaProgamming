package test;

import java.util.*;

import math.Calculator;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n, sign;
        n = sc.nextLine();
        String[] listN = n.split(" ");
        double a = Integer.parseInt(listN[0]);
        double b = Integer.parseInt(listN[2]);
        sign = listN[1];

        Calculator calc = new Calculator();

        double result = calc.calculator(a, b, sign);
        
        System.out.println(result);
    }
}