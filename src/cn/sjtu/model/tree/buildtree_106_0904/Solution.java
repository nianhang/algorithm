package cn.sjtu.model.tree.buildtree_106_0904;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:01
 * @description：从中序与后序遍历序列构造二叉树
 */

public class Solution {

    /**
     * leetcode 106题 从中序与后序遍历序列构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTreeWithInorderPostorder(int[] inorder, int[] postorder) {
        return buildInorderPostorder(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    TreeNode buildInorderPostorder(int[] inorder,int inStart,int inEnd,
                                   int[] postorder,int postStart,int postEnd){
        if(inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        int index = -1;
        for(int i= inStart;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;

        root.left = buildInorderPostorder(inorder,inStart,index-1,
                postorder,postStart,postStart+leftSize-1);
        root.right = buildInorderPostorder(inorder,index+1,inEnd,
                postorder,postStart+leftSize,postEnd-1);

        return root;
    }

}
