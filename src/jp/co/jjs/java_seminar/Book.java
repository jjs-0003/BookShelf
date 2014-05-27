package jp.co.jjs.java_seminar;

import java.io.Serializable;

public class Book implements Serializable {

    private int id;
    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private int price;

    public Book() {
    }

    /**
     * @param id
     *            セットする id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param title
     *            セットする title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param isbn
     *            セットする isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @param author
     *            セットする author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @param publisher
     *            セットする publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @param price
     *            セットする price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    public String showAll() {
        return " ID : " + this.id + " | TITLE : " + this.title + " | ISBN : "
                + this.isbn + " | AUTHOR : " + this.author + " | PUBLISHER : "
                + this.publisher + " | PRICE :  " + this.price + "<br>";
    }

}
