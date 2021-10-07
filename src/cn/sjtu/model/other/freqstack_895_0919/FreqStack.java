package cn.sjtu.model.other.freqstack_895_0919;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-19 16:18
 * @description：最大频率栈
 */

public class FreqStack {

    //记录FreqStack中元素的最大频率
    int maxFreq;
    //记录FreqStack中每个val对应的出现频率，即VF表
    HashMap<Integer,Integer> valToFreq;
    //记录频率freq对应的val列表，即FV表
    HashMap<Integer, Stack<Integer>> freqToVal;

    public FreqStack() {
        maxFreq = 0;
        valToFreq = new HashMap<>();
        freqToVal = new HashMap<>();
    }

    public void push(int val) {
        //修改VF表，val对应的freq+1
        int freq = valToFreq.getOrDefault(val,0) + 1;
        valToFreq.put(val,freq);
        //修改FV表，在freq对应的列表加上Val
        freqToVal.putIfAbsent(freq,new Stack<>());
        freqToVal.get(freq).push(val);
        //更新maxFreq
        maxFreq = Math.max(maxFreq,freq);
    }

    public int pop() {
        //修改FV表，pop出一个maxFreq对应的元素V
        Stack<Integer> vals = freqToVal.get(maxFreq);
        int v = vals.pop();
        //修改VF表，V对应的freq-1
        int freq = valToFreq.get(v) -1;
        valToFreq.put(v,freq);
        //更新maxFreq
        if(vals.isEmpty()){
            //如果maxFreq对应的元素为空
            maxFreq --;
        }
        return v;
    }

}
