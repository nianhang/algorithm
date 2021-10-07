package cn.sjtu.model.tree.zigzaglevelorder_103_0915;

import cn.sjtu.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author £ºlinfd
 * @version :$
 * @date £ºCreated in 2021-09-15 22:46
 * @description£º¶þ²æÊ÷µÄ¾â³ÝÐÎ²ãÐò±éÀú
 */

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean flag = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> back = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(flag){
                    back.add(node.val);
                }else {
                    back.add(0,node.val);
                }

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            result.add(back);
        }
        return result;
    }
}
