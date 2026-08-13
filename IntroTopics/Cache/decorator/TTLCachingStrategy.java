package decorator;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import strategy.CachingStrategy;

public class TTLCachingStrategy<K, V> implements CachingStrategy<K, V> {
    private final CachingStrategy<K, V> delegate;
    private final Expiration<K, V> expiration;
    private final Map<K, Instant> expiry;
    private final int TTL; // in seconds

    public TTLCachingStrategy(CachingStrategy<K, V> delegate, Expiration<K, V> expiration, int TTL) {
        this.delegate = delegate;
        this.expiration = expiration;
        this.TTL = TTL;
        expiry = new HashMap<>();
    }

    @Override
    public V get(K key) {
        if(expiry.containsKey(key) && Instant.now().isAfter(expiry.get(key))) {
            expiry.remove(key);
            expiration.expire(key);
            return null;
        }
        return delegate.get(key);
    }

    @Override
    public void put(K key, V value) {
        expiry.put(key, Instant.now().plusSeconds(TTL));
        delegate.put(key, value);
    }
}
