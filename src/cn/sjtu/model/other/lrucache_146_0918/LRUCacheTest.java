package cn.sjtu.model.other.lrucache_146_0918;

import java.util.HashMap;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-20 9:52
 * @description：自己实现LRU链表结构
 */

public class LRUCacheTest {

    private HashMap<Integer,Node> map;

    private DoubleList cache;

    private int cap;

    public LRUCacheTest(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    //将某个key提升为最近使用的
    private void makeRecently(int key){
        Node x = map.get(key);
        //从链表中删除这个节点
        cache.remove(x);
        //重新插入到队尾
        cache.addLast(x);
    }

    //添加最近使用的元素
    private void addRecently(int key,int val){
        Node x = new Node(key,val);
        //链表尾部就是最近使用的元素
        cache.addLast(x);
        //在map中添加key的映射
        map.put(key,x);
    }

    //删除某一个key
    private void deleteKey(int key){
        Node x = map.get(key);
        //从链表中删除
        cache.remove(x);
        //从map中删除
        map.remove(key);
    }

    //删除最久未使用的元素
    private void removeLeastRecently(){
        //链表头部的第一个元素就是最近未使用的
        Node deletedNode = cache.removeFirst();
        //从map中删除它的key
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    //获取最近的key值
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        //将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    //添加数据
    public void put(int key, int val){
        if(map.containsKey(key)){
            deleteKey(key);
            //新插入的数据为最近使用的数据
            addRecently(key,val);
            return;
        }
        if(cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key,val);
    }




}
