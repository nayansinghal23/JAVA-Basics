package decorator;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import strategy.CachingStrategy;

public class TTLCachingStrategy<K, V> implements CachingStrategy<K, V>, AutoCloseable {
    private final CachingStrategy<K, V> delegate;
    private final Expiration<K, V> expiration;
    private final Map<K, Instant> expiry;
    private final int TTL; // in seconds
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public TTLCachingStrategy(CachingStrategy<K, V> delegate, Expiration<K, V> expiration, int TTL) {
        this.delegate = delegate;
        this.expiration = expiration;
        this.TTL = TTL;
        expiry = new ConcurrentHashMap<>();
        scheduler.scheduleAtFixedRate(this::cleanupExpiredKeys, 1, 1, TimeUnit.MINUTES);
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

    private void cleanupExpiredKeys() {
        Instant now = Instant.now();
    
        expiry.entrySet().removeIf(entry -> {
            if (now.isAfter(entry.getValue())) {
                expiration.expire(entry.getKey());
                return true;
            }
    
            return false;
        });
    }

    @Override
    public void close() throws Exception {
        scheduler.shutdown();
    }
}
