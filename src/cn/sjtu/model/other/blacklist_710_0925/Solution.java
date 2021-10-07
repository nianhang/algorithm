package cn.sjtu.model.other.blacklist_710_0925;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-25 10:28
 * @description：黑名单中的随机数
 */

public class Solution {

    int selectSize;
    //存在黑名单中映射到不存在黑名单的位置；
    Map<Integer,Integer> mapping;
    public Solution(int n, int[] blacklist) {
        selectSize = n - blacklist.length;
        mapping = new HashMap<>();

        for(int bNum : blacklist){
            mapping.put(bNum,Integer.MAX_VALUE);
        }
        int last = n - 1;
        for(int changeNum : blacklist){
            //本身changeNum大于所选的位置，可以不做改变，也不会选到
            if(changeNum >= selectSize){
                mapping.put(changeNum,changeNum);
                continue;
            }
            //尾部中有数字在黑名单中
            while (mapping.containsKey(last)){
                last--;
            }

            mapping.put(changeNum,last);
            last--;
        }
    }

    // 在区间 [0,N) 中等概率随机选取一个元素并返回
    // 这个元素不能是 blacklist 中的元素
    public int pick() {
        int index = (int)(Math.random()*selectSize);

        //命中blackList，则去映射中寻找
        if(mapping.containsKey(index)){
            return mapping.get(index);
        }
        //没有命中的话，直接返回
        return index;
    }


}
