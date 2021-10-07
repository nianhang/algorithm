package cn.sjtu.model.other.lrucache_146_0918;

import java.util.LinkedHashMap;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-18 9:06
 * @description：LRU 缓存机制
 */

public class LRUCache {

    int cap;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size() >= this.cap){
            //链表头部就是最久未使用的key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //将新的key添加链表尾部
        cache.put(key,value);
    }

    private void makeRecently(int key){
        int val = cache.get(key);
        //删除key，重新插入到队尾
        cache.remove(key);
        cache.put(key,val);
    }


}
