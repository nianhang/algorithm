package cn.sjtu.model.tree.mindepth_111_0915;

import cn.sjtu.model.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-15 22:21
 * @description：二叉树的最小深度
 */

public class MinDepth {

    /**
     * 递归
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1+ minDepth(root.left);

        return 1+(int)Math.min(minDepth(root.left),minDepth(root.right));
    }

    /**
     * bfs
     * @param root
     * @return
     */
    public int minDepthWithBFS(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode curNode = queue.poll();
                if(curNode.left == null && curNode.right == null){
                    return level;
                }
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }

            }
            level++;
        }
        return level;

    }


}
