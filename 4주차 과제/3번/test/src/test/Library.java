package test;

import java.util.*;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.printf("도서 추가: %s\n", book.getTitle());
    }

    public void removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                System.out.printf("도서 삭제: %s\n", books.get(i).getTitle());
                books.remove(i);
                return;
            }
        }
        System.out.println("해당 도서가 존재하지 않습니다.");
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.printf("제목: %s\n", book.getTitle());
                System.out.printf("저자: %s\n", book.getAuthor());
                System.out.printf("출판사: %s\n", book.getPublisher());
                System.out.printf("가격: %d원\n", book.getPrice());
                return;
            }
        }
        System.out.println("해당 도서가 존재하지 않습니다.");
    }
}