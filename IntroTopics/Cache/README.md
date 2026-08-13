# Cache LLD

### Requirements ->

1. Implement cache with configurable eviction policies like LRU, LFU.
2. Cache operations support `put(key, value)` & `get(key)`.
3. Mechanism to switch eviction policies dynamically.


### Additionals ->

1. Option to store data on disk. Upon restart, cache should load existing data from the disk.
2. Allow items to expire automatically after a set TTL of say 5 minutes. Implement background cleanup for expired keys.
