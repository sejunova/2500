package academy.pocu.comp2500.lab4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MemoryCache {
    private static Map<String, MemoryCache> cachePool = new LinkedHashMap<>();
    private static int maxInstanceCount = 8096;

    private Map<String, String> entryMap = new HashMap<>();
    private int maxEntryCount = 8096;

    public static MemoryCache getInstance(String cache) {
        if (MemoryCache.cachePool.containsKey(cache)) {
            Map.Entry<String, MemoryCache> cacheToUpdate = MemoryCache.cachePool.entrySet().iterator().next();
            MemoryCache.cachePool.remove(cacheToUpdate.getKey());
            MemoryCache.cachePool.put(cacheToUpdate.getKey(), cacheToUpdate.getValue());
            return cacheToUpdate.getValue();
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
    }

    public void addEntry(String key, String value) {
        this.entryMap.put(key, value);
    }

    public void setMaxEntryCount(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
    }
}
