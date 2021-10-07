package cn.sjtu.model.tree.levelorder_102_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-13 20:24
 * @description：层级遍历
 */

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> back = new LinkedList<>();
            int n = queue.size();
            //把队列中的所有数据进行存储；
            for(int i =0;i<n;i++){
                TreeNode node = queue.poll();
                back.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
           res.add(back);
        }
        return res;
    }


}
