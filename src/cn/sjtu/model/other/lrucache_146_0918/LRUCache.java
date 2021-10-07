package cn.sjtu.model.other.lrucache_146_0918;

import java.util.LinkedHashMap;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-18 9:06
 * @description��LRU �������
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
            //����ͷ���������δʹ�õ�key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //���µ�key�������β��
        cache.put(key,value);
    }

    private void makeRecently(int key){
        int val = cache.get(key);
        //ɾ��key�����²��뵽��β
        cache.remove(key);
        cache.put(key,val);
    }


}
