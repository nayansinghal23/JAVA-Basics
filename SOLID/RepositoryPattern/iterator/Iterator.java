package SOLID.RepositoryPattern.iterator;

import java.util.List;

public interface Iterator {
    boolean hasNext();
    List<String> next();
}
