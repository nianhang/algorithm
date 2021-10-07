package cn.sjtu.model.tree.nestedIterator_341_0911;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-11 16:58
 * @description
 */

public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList){
        // ��Ž� nestedList ��ƽ�Ľ��
        List<Integer> result = new LinkedList<>();
        for(NestedInteger node:nestedList){
            // ��ÿ���ڵ�Ϊ������
            traverse(node,result);
        }
        // �õ� result �б�ĵ�����
        this.it = result.iterator();
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    // ������ root Ϊ���Ķ��������Ҷ�ӽڵ��ֵ���� result �б�
    private void traverse(NestedInteger root, List<Integer> result) {
        if(root.isInteger()){
            // ����Ҷ�ӽڵ�
            result.add(root.getInteger());
            return;
        }
        // �������
        for(NestedInteger child : root.getList()){
            traverse(root,result);
        }
    }

}
