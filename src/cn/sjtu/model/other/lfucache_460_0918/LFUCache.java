package cn.sjtu.model.other.lfucache_460_0918;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-18 10:50
 * @description：LFU 缓存
 */

public class LFUCache {

    //key到val的映射，即KV表
    HashMap<Integer,Integer> keyToVal;
    //key到freq的映射，即KF表
    HashMap<Integer,Integer> keyToFreq;
    //freq到key列表的映射，即FK表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    //记录最小的频次
    int minFreq;
    //记录LFU缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(this.cap <= 0) return;

        //key已经存在，修改key对应的freq
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            //key对应的freq+1
            increaseFreq(key);
            return;
        }
        //key不存在的时候，需要插入
        //容量已经满了，需要淘汰一个freq的最小的key
        if(this.cap <= keyToVal.size()){
            removeMinFreqKey();
        }
        //插入key和val，对应的freq为1
        //插入KV表
        keyToVal.put(key,value);
        //插入KF表
        keyToFreq.put(key,1);
        //插入FK表
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        //插入新key后最小的freq肯定是1；
        this.minFreq = 1;
    }

    public void increaseFreq(int key){

        int freq = keyToFreq.get(key);
        //更新KF表
        keyToFreq.put(key,freq+1);
        //更新FK表
        //将key从freq对应的列表中删除
        freqToKeys.get(freq).remove(key);
        //将key 加入到freq+1对应的列表中
        freqToKeys.putIfAbsent(freq + 1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        //如果freq对应的列表空了，移除这个freq
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            //如果这个freq恰好是minFreq，更新minFreq
            if(freq == this.minFreq){
                this.minFreq++;
            }
        }

    }

    public void removeMinFreqKey(){
        //获取freq中最小的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        //其中最先被插入的那个key就是该被淘汰的key
        int deletedKey = keyList.iterator().next();
        //更新FK表
        keyList.remove(deletedKey);
        if(keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
        //更新KV表
        keyToVal.remove(deletedKey);
        //更新KF表
        keyToFreq.remove(deletedKey);
    }
}
