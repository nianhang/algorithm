package cn.sjtu.model.other.randomizedset_380_0924;

import java.util.*;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-24 19:36
 * @description：O(1) 时间插入、删除和获取随机元素
 */

public class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        randomizedSet.insert(0);
        randomizedSet.insert(10);
        randomizedSet.insert(20);
        randomizedSet.insert(30);

        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());


    }



    List<Integer>  nums;
    HashMap<Integer,Integer> valToIndex;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)){
            return false;
        }
        nums.add(val);
        valToIndex.put(val,nums.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)){
            return false;
        }
        int index = valToIndex.get(val);
        int lastNumber = nums.get(nums.size() - 1);
        valToIndex.put(lastNumber,index);
        valToIndex.remove(val);

        Collections.swap(nums,index,nums.size()-1);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomNo = (int)(Math.random()*nums.size());
        return nums.get(randomNo);
    }

}
