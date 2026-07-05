package repositry;

import java.util.List;

import book.Book;
import db.InMemoryDB;
import enums.BookCategory;

public class BooksRepositry implements Repositry {
    private final InMemoryDB db;

    public BooksRepositry() {
        this.db = new InMemoryDB();
    }

    @Override
    public void addBook(Book book) {
        db.addBook(book);
    }

    @Override
    public void removeBook(Book book) {
        db.removeBook(book);
    }

    @Override
    public void updateBook(Book book) {
        db.updateBook(book);
    }

    @Override
    public List<Book> getBooks(int limit, int offset) {
        List<Book> books = db.getBooks();
        int start = (offset - 1) * limit;
        int end = Math.min(start + limit, books.size());
        return books.subList(start, end);
    }

    @Override
    public List<Book> getBooksByCategory(BookCategory category, int limit, int offset) {
        List<Book> books = db.getBooksByCategory(category);
        int start = (offset - 1) * limit;
        int end = Math.min(start + limit, books.size());
        return books.subList(start, end);
    }
}
