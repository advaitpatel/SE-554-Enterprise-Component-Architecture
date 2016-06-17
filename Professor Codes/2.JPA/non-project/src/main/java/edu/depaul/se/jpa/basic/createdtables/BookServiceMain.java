package edu.depaul.se.jpa.basic.createdtables;

import java.util.List;

/**
 * Demo using Service class
 */
public class BookServiceMain {
    public static void main(String[] args) {
        BookService bookEntityService = new BookService();
        Book book = new Book();
        book.setTitle("Beginning Java Persistence 2nd Ed");
        bookEntityService.saveBook(book);

        List<Book> books = bookEntityService.getAllBooks();        
        System.out.println(books.size());
        bookEntityService.deleteBook(book.getId());
    }
}
