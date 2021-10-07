package cn.sjtu.model.tree.flatten_114_0903;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 16:56
 * @description： 二叉树展开为链表
 */

public class Solution {

    /**
     * leetcode 114题 二叉树展开为链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }


}
