package test;

import java.util.*;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        Animal A = new Animal("뽀삐", 3);
        Dog D = new Dog("백구", 2, "진돗개");
        Cat C = new Cat("톰", 1, "검은색");

        System.out.printf("%s는 %d살이고 ", A.name, A.age);
        A.speak();
        System.out.printf("%s는 %d살이고 ", D.name, D.age);
        D.speak();
        System.out.printf("%s는 %d살이고 ", C.name, C.age);
        C.speak();
    }
}