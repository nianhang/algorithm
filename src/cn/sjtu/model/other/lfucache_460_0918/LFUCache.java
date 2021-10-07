package cn.sjtu.model.other.lfucache_460_0918;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-18 10:50
 * @description��LFU ����
 */

public class LFUCache {

    //key��val��ӳ�䣬��KV��
    HashMap<Integer,Integer> keyToVal;
    //key��freq��ӳ�䣬��KF��
    HashMap<Integer,Integer> keyToFreq;
    //freq��key�б��ӳ�䣬��FK��
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    //��¼��С��Ƶ��
    int minFreq;
    //��¼LFU������������
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

        //key�Ѿ����ڣ��޸�key��Ӧ��freq
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            //key��Ӧ��freq+1
            increaseFreq(key);
            return;
        }
        //key�����ڵ�ʱ����Ҫ����
        //�����Ѿ����ˣ���Ҫ��̭һ��freq����С��key
        if(this.cap <= keyToVal.size()){
            removeMinFreqKey();
        }
        //����key��val����Ӧ��freqΪ1
        //����KV��
        keyToVal.put(key,value);
        //����KF��
        keyToFreq.put(key,1);
        //����FK��
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        //������key����С��freq�϶���1��
        this.minFreq = 1;
    }

    public void increaseFreq(int key){

        int freq = keyToFreq.get(key);
        //����KF��
        keyToFreq.put(key,freq+1);
        //����FK��
        //��key��freq��Ӧ���б���ɾ��
        freqToKeys.get(freq).remove(key);
        //��key ���뵽freq+1��Ӧ���б���
        freqToKeys.putIfAbsent(freq + 1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        //���freq��Ӧ���б���ˣ��Ƴ����freq
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            //������freqǡ����minFreq������minFreq
            if(freq == this.minFreq){
                this.minFreq++;
            }
        }

    }

    public void removeMinFreqKey(){
        //��ȡfreq����С��key�б�
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        //�������ȱ�������Ǹ�key���Ǹñ���̭��key
        int deletedKey = keyList.iterator().next();
        //����FK��
        keyList.remove(deletedKey);
        if(keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
        //����KV��
        keyToVal.remove(deletedKey);
        //����KF��
        keyToFreq.remove(deletedKey);
    }
}
