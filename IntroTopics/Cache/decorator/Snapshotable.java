package decorator;

import java.util.Map;

public interface Snapshotable<K, V> {
    Map<K, V> snapshot();
}
