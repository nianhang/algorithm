package cn.sjtu.model.tree.insertintobst_701_0906;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:10
 * @description：二叉搜索树中的插入操作
 */

public class Solution {

    /**
     * leetcode 701题  二叉搜索树（BST）中的插入操作,插入一个数字
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if(root == null) return new TreeNode(val);

        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }else if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

}
