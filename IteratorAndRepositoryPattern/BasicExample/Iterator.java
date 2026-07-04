import java.util.List;

public interface Iterator<T> { // Generic type T is the type of the elements in the collection
    boolean hasNext();
    List<T> next();
}
