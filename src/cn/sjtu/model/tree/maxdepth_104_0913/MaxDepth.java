package cn.sjtu.model.tree.maxdepth_104_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-13 22:20
 * @description：二叉树的最大深度
 */

public class MaxDepth {

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+ (int)Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public int maxDepthIteration(TreeNode root){
        if(root == null) return 0;

        int h = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i =0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            h++;
        }
        return h;
    }

}
