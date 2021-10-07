package cn.sjtu.model.tree.buildtree_105_0904;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 16:59
 * @description����ǰ��������������й��������
 */

public class Solution {

    /**
     * leetcode 105�� ��ǰ��������������й��������
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
        // root �ڵ��Ӧ��ֵ����ǰ���������ĵ�һ��Ԫ��
        int rootVal = preorder[preStart];
        int index = -1;
        // rootVal ��������������е�����
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
