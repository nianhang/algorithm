package cn.sjtu.model.tree.isvalidbst_98_0905;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:07
 * @description：验证二叉搜索树
 */

public class Solution {

    //二叉搜索树（第二期）
    /**
     * leetcode 98题 验证二叉搜索树（BST）
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTWithTreeParam(root,null,null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBSTWithTreeParam(TreeNode root,TreeNode min,TreeNode max){
        if(root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBSTWithTreeParam(root.left,min,root)
                && isValidBSTWithTreeParam(root.right,root,max);
    }
}
