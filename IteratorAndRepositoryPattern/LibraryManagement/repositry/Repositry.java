package repositry;

import java.util.List;

import book.Book;
import enums.BookCategory;

public interface Repositry {
    void addBook(Book book);
    void removeBook(Book book);
    void updateBook(Book book);
    List<Book> getBooks(int limit, int offset);
    List<Book> getBooksByCategory(BookCategory category, int limit, int offset);
}
