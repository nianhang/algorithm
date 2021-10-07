package cn.sjtu.model.tree.inverttree_226_0903;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :easy$
 * @date ：Created in 2021-10-07 16:53
 * @description：翻转二叉树
 */

public class Solution {

    //第一期
    /**
     * leetcode226题 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
