package cn.sjtu.model.tree.generatetrees_95_0907;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:14
 * @description����ͬ�Ķ��������� II
 */

public class Solution {

    /**
     * leetcode 95��   ��ͬ�Ķ���������II(BST)�Ĺ���
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return buildTreeList(1,n);
    }

    /* ��������� [lo, hi] ��ɵ� BST */
    List<TreeNode> buildTreeList(int lo,int hi){
        List<TreeNode> res = new LinkedList<>();
        if(lo > hi){
            res.add(null);
            return res;
        }
        // 1����� root �ڵ�����п��ܡ�
        for(int i = lo;i<= hi;i++){
            // 2���ݹ鹹����������������кϷ� BST��
            List<TreeNode> leftTree = buildTreeList(lo,i-1);
            List<TreeNode> rightTree = buildTreeList(i+1,hi);
            // 3���� root �ڵ��������������������ϡ�
            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    // i ��Ϊ���ڵ� root ��ֵ
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
