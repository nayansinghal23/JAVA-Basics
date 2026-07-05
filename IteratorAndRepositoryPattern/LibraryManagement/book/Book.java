package book;

import enums.BookCategory;

public class Book {
    private final int id;
    private final String title;
    private final BookCategory category;
    private final boolean isAvailable;

    public Book(BookBuilder builder) {
        this.id = builder.getId();
        this.title = builder.getTitle();
        this.category = builder.getCategory();
        this.isAvailable = builder.isAvailable();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BookCategory getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
