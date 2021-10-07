package cn.sjtu.model.other.freqstack_895_0919;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-19 16:18
 * @description�����Ƶ��ջ
 */

public class FreqStack {

    //��¼FreqStack��Ԫ�ص����Ƶ��
    int maxFreq;
    //��¼FreqStack��ÿ��val��Ӧ�ĳ���Ƶ�ʣ���VF��
    HashMap<Integer,Integer> valToFreq;
    //��¼Ƶ��freq��Ӧ��val�б���FV��
    HashMap<Integer, Stack<Integer>> freqToVal;

    public FreqStack() {
        maxFreq = 0;
        valToFreq = new HashMap<>();
        freqToVal = new HashMap<>();
    }

    public void push(int val) {
        //�޸�VF��val��Ӧ��freq+1
        int freq = valToFreq.getOrDefault(val,0) + 1;
        valToFreq.put(val,freq);
        //�޸�FV����freq��Ӧ���б����Val
        freqToVal.putIfAbsent(freq,new Stack<>());
        freqToVal.get(freq).push(val);
        //����maxFreq
        maxFreq = Math.max(maxFreq,freq);
    }

    public int pop() {
        //�޸�FV��pop��һ��maxFreq��Ӧ��Ԫ��V
        Stack<Integer> vals = freqToVal.get(maxFreq);
        int v = vals.pop();
        //�޸�VF��V��Ӧ��freq-1
        int freq = valToFreq.get(v) -1;
        valToFreq.put(v,freq);
        //����maxFreq
        if(vals.isEmpty()){
            //���maxFreq��Ӧ��Ԫ��Ϊ��
            maxFreq --;
        }
        return v;
    }

}
