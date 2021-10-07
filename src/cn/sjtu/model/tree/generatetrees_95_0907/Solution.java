package cn.sjtu.model.tree.generatetrees_95_0907;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:14
 * @description：不同的二叉搜索树 II
 */

public class Solution {

    /**
     * leetcode 95题   求不同的二叉搜索树II(BST)的构造
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return buildTreeList(1,n);
    }

    /* 构造闭区间 [lo, hi] 组成的 BST */
    List<TreeNode> buildTreeList(int lo,int hi){
        List<TreeNode> res = new LinkedList<>();
        if(lo > hi){
            res.add(null);
            return res;
        }
        // 1、穷举 root 节点的所有可能。
        for(int i = lo;i<= hi;i++){
            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = buildTreeList(lo,i-1);
            List<TreeNode> rightTree = buildTreeList(i+1,hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;

    }

}
