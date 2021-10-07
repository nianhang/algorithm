package cn.sjtu.model.tree.kthsmallest_230_0905;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:04
 * @description：二叉搜索树中第K小的元素
 */

public class Solution {

    //二叉搜索树（第一期）
    /**
     * leetCode 第230题 二叉搜索树中第K小的元素
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        traverseTree(root,k);
        return resTree;
    }

    int resTree = 0;
    int rank = 0;
    void traverseTree(TreeNode root,int k){
        if(root == null) return;
        traverseTree(root.left,k);
        // 中序遍历代码位置
        rank++;
        if(k == rank){
            // 找到第 k 小的元素
            resTree = root.val;
            return;
        }
        traverseTree(root.right,k);
    }

}
