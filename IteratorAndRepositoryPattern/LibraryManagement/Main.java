import repositry.BooksRepositry;
import iterator.GetBooksIterator;
import iterator.CategroizedBooksIterator;
import library.Library;
import enums.BookCategory;
import java.util.List;
import book.Book;

public class Main {
    public static void main(String[] args) {
        BooksRepositry booksRepositry = new BooksRepositry();
        GetBooksIterator getBooksIterator = new GetBooksIterator(booksRepositry, 1, 10);
        CategroizedBooksIterator categroizedBooksIterator = new CategroizedBooksIterator(booksRepositry, 1, 10, BookCategory.FICTION);
        Library library = new Library(getBooksIterator, categroizedBooksIterator);
        List<Book> books = library.getBooks(1, 10);
        List<Book> fictionBooks = library.getBooksByCategory(BookCategory.FICTION, 1, 10);
        System.out.println(books);
        System.out.println(fictionBooks);
    }
}