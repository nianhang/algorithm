package cn.sjtu.model.tree.nestedIterator_341_0911;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-11 17:33
 * @description��
 */

public class NestedIteratorOptimization implements Iterator<Integer> {

    private LinkedList<NestedInteger> list;
    public NestedIteratorOptimization(List<NestedInteger> nestedList){

        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        // hasNext ������֤�˵�һ��Ԫ��һ������������
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        // ѭ������б�Ԫ�أ�ֱ���б��һ��Ԫ������������
        while(!list.isEmpty() && !list.get(0).isInteger()){
            // ���б�ͷ��һ��Ԫ�����б�����ʱ������ѭ��
            List<NestedInteger> first = list.remove(0).getList();
            // ����һ���б��ƽ����˳����ӵ���ͷ
            for(int i = first.size() - 1;i >= 0;i --){
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }


}
