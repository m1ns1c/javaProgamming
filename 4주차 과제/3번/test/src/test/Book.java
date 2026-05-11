package test;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int price;

    public Book(String title, String author, String publisher, int price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }
}