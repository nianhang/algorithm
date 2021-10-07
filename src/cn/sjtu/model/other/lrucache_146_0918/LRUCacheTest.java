package cn.sjtu.model.other.lrucache_146_0918;

import java.util.HashMap;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-20 9:52
 * @description���Լ�ʵ��LRU����ṹ
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
    //��ĳ��key����Ϊ���ʹ�õ�
    private void makeRecently(int key){
        Node x = map.get(key);
        //��������ɾ������ڵ�
        cache.remove(x);
        //���²��뵽��β
        cache.addLast(x);
    }

    //������ʹ�õ�Ԫ��
    private void addRecently(int key,int val){
        Node x = new Node(key,val);
        //����β���������ʹ�õ�Ԫ��
        cache.addLast(x);
        //��map�����key��ӳ��
        map.put(key,x);
    }

    //ɾ��ĳһ��key
    private void deleteKey(int key){
        Node x = map.get(key);
        //��������ɾ��
        cache.remove(x);
        //��map��ɾ��
        map.remove(key);
    }

    //ɾ�����δʹ�õ�Ԫ��
    private void removeLeastRecently(){
        //����ͷ���ĵ�һ��Ԫ�ؾ������δʹ�õ�
        Node deletedNode = cache.removeFirst();
        //��map��ɾ������key
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    //��ȡ�����keyֵ
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        //������������Ϊ���ʹ�õ�
        makeRecently(key);
        return map.get(key).val;
    }

    //�������
    public void put(int key, int val){
        if(map.containsKey(key)){
            deleteKey(key);
            //�²��������Ϊ���ʹ�õ�����
            addRecently(key,val);
            return;
        }
        if(cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key,val);
    }




}
