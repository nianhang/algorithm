package cn.sjtu.model.tree.searchbst_700_0906;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :easy$
 * @date ：Created in 2021-10-07 17:08
 * @description：二叉搜索树中的搜索
 */

public class Solution {

    //第二期 9.06

    /**
     * leetcode 700题  二叉搜索树（BST）中的搜索,在 BST 中搜索一个数
     * @param root
     * @param val
     * @return
     */
    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val > val) {
            return searchBST(root.left,val);
        }else if(root.val < val){
            return searchBST(root.right,val);
        }else {
            return root;
        }
    }
}
