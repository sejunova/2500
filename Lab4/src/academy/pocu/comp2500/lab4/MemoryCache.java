package academy.pocu.comp2500.lab4;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class MemoryCache {
    private static Map<String, MemoryCache> cachePool = new LinkedHashMap<>();
    private static int maxInstanceCount = Integer.MAX_VALUE;

    private Map<String, String> lruEntries = new LinkedHashMap<>();
    private LinkedList<String> entries = new LinkedList<>();
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

    public void addEntry(String key, String value) {
        if (this.lruEntries.size() == this.maxEntryCount) {
            evictEntry();
        }
        this.lruEntries.put(key, value);
        this.entries.add(key);
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

        if (this.evictionPolicy.equals(EvictionPolicy.LEAST_RECENTLY_USED)) {
            String entryToUpdate = this.lruEntries.get(key);
            this.lruEntries.remove(key);
            this.lruEntries.put(key, entryToUpdate);
        }
        return value;
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    private void evictEntry() {
        if (this.evictionPolicy.equals(EvictionPolicy.LAST_IN_FIRST_OUT)) {
            String lastEntryKey = this.lruEntries.entrySet().stream().skip(this.lruEntries.size() - 1).findFirst().get().getKey();
            this.lruEntries.remove(lastEntryKey);
            this.entries.removeLast();
        } else {
            String firstEntryKey = this.lruEntries.entrySet().iterator().next().getKey();
            this.lruEntries.remove(firstEntryKey);
            this.entries.removeFirst();
        }
    }
}
