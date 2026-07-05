package iterator;

import java.util.ArrayList;
import java.util.List;

import book.Book;
import repositry.BooksRepositry;

public class GetBooksIterator implements Iterator<Book> {
    private final BooksRepositry booksRepositry;
    private int offset = 1;
    private int limit = 10;
    private List<Book> books = new ArrayList<>();

    public GetBooksIterator(BooksRepositry booksRepositry, int offset, int limit) {
        this.booksRepositry = booksRepositry;
        this.offset = offset;
        this.limit = limit;
        this.books = booksRepositry.getBooks(limit, offset);
    }

    @Override
    public boolean hasNext() {
        return !books.isEmpty();
    }

    @Override
    public List<Book> next() {
        List<Book> currentBooks = books;
        offset += limit;
        books = booksRepositry.getBooks(limit, offset);
        return currentBooks;
    }
}
