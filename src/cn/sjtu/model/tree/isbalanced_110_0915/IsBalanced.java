package cn.sjtu.model.tree.isbalanced_110_0915;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-15 23:24
 * @description：平衡二叉树
 */

public class IsBalanced {

    /**
     * 自顶向下
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        int left = high(root.left);
        int right = high(root.right);

        if(Math.abs(left-right) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int high(TreeNode node){
        if(node == null) return 0;
        if(node.left == null) return 1+high(node.right);
        if(node.right == null) return 1+high(node.left);
        return 1+ Math.max(high(node.left),high(node.right));
    }

}
