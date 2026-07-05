package book;

import enums.BookCategory;

public class BookBuilder {
    private final int id;
    private final String title;
    private final BookCategory category;
    private final boolean isAvailable;

    public BookBuilder(int id, String title, BookCategory category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.isAvailable = isAvailable;
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

    public Book build() {
        return new Book(this);
    }
}
