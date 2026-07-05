package library;

import java.util.List;

import book.Book;
import enums.BookCategory;
import iterator.CategroizedBooksIterator;
import iterator.GetBooksIterator;

public class Library {
    private final GetBooksIterator getBooksIterator;
    private final CategroizedBooksIterator categroizedBooksIterator;

    public Library(GetBooksIterator getBooksIterator, CategroizedBooksIterator categroizedBooksIterator) {
        this.getBooksIterator = getBooksIterator;
        this.categroizedBooksIterator = categroizedBooksIterator;
    }

    public List<Book> getBooks(int offset, int limit) {
        return getBooksIterator.hasNext() ? getBooksIterator.next() : null;
    }

    public List<Book> getBooksByCategory(BookCategory category, int offset, int limit) {
        return categroizedBooksIterator.hasNext() ? categroizedBooksIterator.next() : null;
    }
}
