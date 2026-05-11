package test;

import java.util.*;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        Rectangle R = new Rectangle(100, 200, "blue", 300, 400);
        Circle C = new Circle(100, 200, "white", 300);
        Triangle T = new Triangle(100, 200, "yellow", 300, 400);
        
        System.out.printf("사각형은 (%d, %d)에 위치하며 색상은 %s이고 면적은 %.0f입니다.\n", R.x, R.y, R.color, R.getArea());
        System.out.printf("원은 (%d, %d)에 위치하며 색상은 %s이고 면적은 %.0f입니다.\n", C.x, C.y, C.color, C.getArea());
        System.out.printf("삼각형은 (%d, %d)에 위치하며 색상은 %s이고 면적은 %.0f입니다.\n", T.x, T.y, T.color, T.getArea());
    }
}