package test;

import java.util.*;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Dice a = new Dice();
        Dice b = new Dice();

        int count = 0;

        System.out.println("엔터를 누르면 주사위 시작!");
        sc.nextLine();

        while (true) {
        	
        	System.out.println("주사위1 = " + a.getValue() + " 주사위2 = " + b.getValue());
        	
            a.roll();
            b.roll();
            
            count++;
  
            if (a.getValue() + b.getValue() == 2) {
                break;
            }
        }

        System.out.println("(1,1)이 나오는데 걸린 횟수 = " + count);
    }
}