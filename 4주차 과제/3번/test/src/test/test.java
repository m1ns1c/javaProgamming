package test;

import java.util.*;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine(); 

            if (menu == 1) {
                System.out.print("제목: ");
                String title = sc.nextLine();

                System.out.print("저자: ");
                String author = sc.nextLine();

                System.out.print("출판사: ");
                String publisher = sc.nextLine();

                System.out.print("가격: ");
                int price = sc.nextInt();
                sc.nextLine();

                Book b = new Book(title, author, publisher, price);
                lib.addBook(b);

            } else if (menu == 2) {
                System.out.print("책 제목: ");
                String title = sc.nextLine();
                lib.searchBook(title);

            } else if (menu == 3) {
                System.out.print("삭제할 책 제목: ");
                String title = sc.nextLine();
                lib.removeBook(title);
                
            } else if (menu == 4) {
                System.out.println("프로그램 종료");
                break;
            }

            System.out.println();
        }
    }
}