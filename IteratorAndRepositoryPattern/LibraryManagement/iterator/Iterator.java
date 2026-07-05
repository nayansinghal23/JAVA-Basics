package iterator;

import java.util.List;

public interface Iterator<T> {
    boolean hasNext();
    List<T> next();
}
