package cn.sjtu.model.tree.nestedIterator_341_0911;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-11 17:33
 * @description：
 */

public class NestedIteratorOptimization implements Iterator<Integer> {

    private LinkedList<NestedInteger> list;
    public NestedIteratorOptimization(List<NestedInteger> nestedList){

        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        // hasNext 方法保证了第一个元素一定是整数类型
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        // 循环拆分列表元素，直到列表第一个元素是整数类型
        while(!list.isEmpty() && !list.get(0).isInteger()){
            // 当列表开头第一个元素是列表类型时，进入循环
            List<NestedInteger> first = list.remove(0).getList();
            // 将第一个列表打平并按顺序添加到开头
            for(int i = first.size() - 1;i >= 0;i --){
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }


}
