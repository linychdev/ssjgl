package com.ustb.ssjgl.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MapCache;
import org.apache.shiro.util.SoftHashMap;

public class MemoryCacheManager extends AbstractCacheManager {

    private int size = 2000;
    
    public int getSize() {
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }
    
    /**
     * Returns a new {@link MapCache MapCache} instance backed by a {@link SoftHashMap}.
     *
     * @param name the name of the cache
     * @return a new {@link MapCache MapCache} instance backed by a {@link SoftHashMap}.
     */
    @Override
    protected Cache<Object, Object> createCache(String name) {
        return new MapCache<Object, Object>(name, new SoftHashMap<Object, Object>(size));
    }

}
