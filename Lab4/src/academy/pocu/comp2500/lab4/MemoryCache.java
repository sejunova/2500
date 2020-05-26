package academy.pocu.comp2500.lab4;

import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryCache {
    private static Map<String, MemoryCache> cachePool = new LinkedHashMap<>();
    private static int maxInstanceCount = Integer.MAX_VALUE;

    private Map<String, String> lruEntries = new LinkedHashMap<>();
    private Map<String, String> fifo = new LinkedHashMap<>();
    private Map<String, String> lifo = new LinkedHashMap<>();
    private int maxEntryCount = Integer.MAX_VALUE;
    private EvictionPolicy evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;

    public static MemoryCache getInstance(String cache) {
        if (MemoryCache.cachePool.containsKey(cache)) {
            MemoryCache cacheToUpdate = MemoryCache.cachePool.get(cache);
            MemoryCache.cachePool.remove(cache);
            MemoryCache.cachePool.put(cache, cacheToUpdate);
            return cacheToUpdate;
        } else {
            if (MemoryCache.cachePool.size() == MemoryCache.maxInstanceCount) {
                String cacheKeyToDelete = MemoryCache.cachePool.entrySet().iterator().next().getKey();
                MemoryCache.cachePool.remove(cacheKeyToDelete);
            }
            MemoryCache memoryCache = new MemoryCache();
            MemoryCache.cachePool.put(cache, memoryCache);
            return memoryCache;
        }
    }

    public static void setMaxInstanceCount(int maxInstanceCount) {
        MemoryCache.maxInstanceCount = maxInstanceCount;
        while (MemoryCache.maxInstanceCount < MemoryCache.cachePool.size()) {
            String cacheKeyToDelete = MemoryCache.cachePool.entrySet().iterator().next().getKey();
            MemoryCache.cachePool.remove(cacheKeyToDelete);
        }
    }

    public static void clear() {
        MemoryCache.cachePool.clear();
    }

    public void addEntry(String key, String value) {
        if (!this.lruEntries.containsKey(key) && this.lruEntries.size() == this.maxEntryCount) {
            evictEntry();
        }
        this.fifo.put(key, value);
        this.lifo.put(key, value);
        this.lruEntries.remove(key);
        this.lruEntries.put(key, value);
    }

    public void setMaxEntryCount(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
        while (this.maxEntryCount < this.lruEntries.size()) {
            evictEntry();
        }
    }

    public String getEntryOrNull(String key) {
        String value = this.lruEntries.getOrDefault(key, null);
        if (value == null) {
            return null;
        }

        this.lruEntries.remove(key);
        this.lruEntries.put(key, value);
        return value;
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    private void evictEntry() {
        String entryToDelete;
        switch (this.evictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                entryToDelete = this.fifo.entrySet().iterator().next().getKey();
                this.fifo.remove(entryToDelete);
                this.lifo.remove(entryToDelete);
                this.lruEntries.remove(entryToDelete);
                break;
            case LAST_IN_FIRST_OUT:
                Map.Entry<String, String> toDelete = (Map.Entry<String, String>) lifo.entrySet().toArray()[this.lruEntries.size() - 1];

                this.fifo.remove(toDelete.getKey());
                this.lifo.remove(toDelete.getKey());
                this.lruEntries.remove(toDelete.getKey());
                break;
            case LEAST_RECENTLY_USED:
                entryToDelete = this.lruEntries.entrySet().iterator().next().getKey();
                this.fifo.remove(entryToDelete);
                this.lifo.remove(entryToDelete);
                this.lruEntries.remove(entryToDelete);
                break;
            default:
                throw new RuntimeException("wrong type");
        }
    }
}
