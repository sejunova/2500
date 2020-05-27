package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryCache {
    private static Map<String, MemoryCache> cachePool = new LinkedHashMap<>();
    private static int maxInstanceCount = Integer.MAX_VALUE;

    private Map<String, String> lruEntries = new LinkedHashMap<>();
    private Map<String, String> queueEntries = new LinkedHashMap<>();
    private int maxEntryCount = Integer.MAX_VALUE;
    private EvictionPolicy evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;

    private MemoryCache() {
    }

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
        this.queueEntries.put(key, value);
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
                entryToDelete = this.queueEntries.entrySet().iterator().next().getKey();
                this.queueEntries.remove(entryToDelete);
                this.lruEntries.remove(entryToDelete);
                break;
            case LAST_IN_FIRST_OUT:
                List<Map.Entry<String, String>> entryList = new ArrayList<>(this.queueEntries.entrySet());
                entryToDelete = entryList.get(entryList.size() - 1).getKey();

                this.queueEntries.remove(entryToDelete);
                this.lruEntries.remove(entryToDelete);
                break;
            case LEAST_RECENTLY_USED:
                entryToDelete = this.lruEntries.entrySet().iterator().next().getKey();
                this.queueEntries.remove(entryToDelete);
                this.lruEntries.remove(entryToDelete);
                break;
            default:
                throw new RuntimeException("wrong type");
        }
    }
}
