package cn.sjtu.model.tree.buildtree_105_0904;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 16:59
 * @description：从前序与中序遍历序列构造二叉树
 */

public class Solution {

    /**
     * leetcode 105题 从前序与中序遍历序列构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeWithPreorderInorder(int[] preorder, int[] inorder) {

        return buildPreorderInorder(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    TreeNode buildPreorderInorder(int[] preorder,int preStart,int preEnd,
                                  int[] inorder,int inStart,int inEnd){

        if(preStart > preEnd) return null;
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        int index = -1;
        // rootVal 在中序遍历数组中的索引
        for(int i =inStart;i<= inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index -inStart;
        root.left = buildPreorderInorder(preorder,preStart+1,preStart+leftSize,
                inorder,inStart,index-1);
        root.right = buildPreorderInorder(preorder,preStart+leftSize+1,preEnd,
                inorder,index+1,inEnd);

        return root;
    }
}
