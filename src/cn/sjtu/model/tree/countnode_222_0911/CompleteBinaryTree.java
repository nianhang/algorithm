package cn.sjtu.model.tree.countnode_222_0911;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-11 18:28
 * @description：
 */

public class CompleteBinaryTree {

    //一般二叉树求节点个数
    public int countNodesNormal(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodesNormal(root.left) + countNodesNormal(root.right);
    }

    //满二叉树
    public int countNodesPerfect(TreeNode root) {
        int h = 0;
        while(root != null){
            root = root.left;
            h++;
        }
        return (int)Math.pow(2,h) - 1;
    }

    //完全二叉树
    public int countNodesComplete(TreeNode root) {

        TreeNode left = root;
        TreeNode right = root;

        int highLeft = 0;
        int highRight = 0;

        while(left != null){
            left = left.left;
            highLeft++;
        }
        while(right != null){
            right = right.right;
            highRight++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if(highLeft == highRight){
            return (int)Math.pow(2,highLeft) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodesComplete(root.left) + countNodesComplete(root.right);
    }




}
