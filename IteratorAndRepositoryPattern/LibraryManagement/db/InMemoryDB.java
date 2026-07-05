package db;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import book.Book;
import enums.BookCategory;

public class InMemoryDB {
    private final List<Book> books;

    public InMemoryDB() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void updateBook(Book book) {
        books.set(books.indexOf(book), book);
    }

    public List<Book> getBooksByCategory(BookCategory category) {
        return books.stream()
            .filter(book -> book.getCategory() == category)
            .collect(Collectors.toList());
    }
}
