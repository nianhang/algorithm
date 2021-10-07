package cn.sjtu.model.tree.nestedIterator_341_0911;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-11 16:58
 * @description
 */

public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList){
        // 存放将 nestedList 打平的结果
        List<Integer> result = new LinkedList<>();
        for(NestedInteger node:nestedList){
            // 以每个节点为根遍历
            traverse(node,result);
        }
        // 得到 result 列表的迭代器
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

    // 遍历以 root 为根的多叉树，将叶子节点的值加入 result 列表
    private void traverse(NestedInteger root, List<Integer> result) {
        if(root.isInteger()){
            // 到达叶子节点
            result.add(root.getInteger());
            return;
        }
        // 遍历框架
        for(NestedInteger child : root.getList()){
            traverse(root,result);
        }
    }

}
