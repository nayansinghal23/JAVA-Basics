package DataPersistanceStrategy;

import decorator.Snapshotable;
import repository.Repository;
import strategy.CachingStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class WriteBackCache<K, V> implements DataPersistanceStrategy<K, V>, AutoCloseable {
    private static final int FLUSH_INTERVAL_SECONDS = 5;

    private final CachingStrategy<K, V> delegate;
    private final Snapshotable<K, V> snapshotable;
    private final Repository<K, V> repository;
    private final AtomicBoolean dirty = new AtomicBoolean(false);
    private final ScheduledExecutorService scheduler;

    public WriteBackCache(CachingStrategy<K, V> delegate, Snapshotable<K, V> snapshotable, Repository<K, V> repository) {
        this.delegate = delegate;
        this.repository = repository;
        this.snapshotable = snapshotable;

        this.scheduler = Executors.newSingleThreadScheduledExecutor(WriteBackCache::newDaemonThread);
        this.scheduler.scheduleAtFixedRate(this::flush, FLUSH_INTERVAL_SECONDS, FLUSH_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    @Override
    public void persist(K key, V value) {
        synchronized (snapshotable) {
            delegate.put(key, value);
            dirty.set(true);
        }
    }

    private void flush() {
        synchronized (snapshotable) {
            if (dirty.compareAndSet(true, false)) {
                repository.saveAll(snapshotable.snapshot());
            }
        }
    }

    @Override
    public void close() {
        flush();
        scheduler.shutdownNow();
    }

    private static Thread newDaemonThread(Runnable task) {
        Thread thread = new Thread(task, "write-back-flush");
        thread.setDaemon(true);
        return thread;
    }
}
