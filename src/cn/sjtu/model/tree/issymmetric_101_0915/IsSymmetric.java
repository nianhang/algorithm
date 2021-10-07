package cn.sjtu.model.tree.issymmetric_101_0915;

import cn.sjtu.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-15 16:03
 * @description���Գƶ�����
 */

public class IsSymmetric {

    /**
     * ��������α�����
     * @param root
     * @return
     */
    public boolean isSymmetricIteration(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    /**
     * �ݹ�
     * @param root
     * @return
     */
    public boolean isSymmetricRecursion(TreeNode root) {
        if(root == null) return true;
        return dfs(root.right,root.left);
    }

    boolean dfs(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

}
