package test;

import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {
            System.out.print("학번 이름을 입력하세요.(종료: exit) : ");
            String n = sc.nextLine();

            if (n.equals("exit")) {
            	break;
            }
            
            String[] nList = n.split(" ");
            String id = nList[0];
            String name = nList[1];

            Student newStudent = new Student(id, name);

            boolean b = false;

            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);
                
                boolean same = s.equals(newStudent);
                
                if (same == true) {
                    b = true;
                    break;
                }
            }

            if (b) {
                System.out.println("이미 등록되어 있습니다.");
                continue;
            }

            list.add(newStudent);
            System.out.println("추가되었습니다.");

            try {
            	FileWriter writer = new FileWriter("/Users/m1ns1c/Desktop/students.txt", true);
                writer.write(newStudent.toString() + "\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}