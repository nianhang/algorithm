package cn.sjtu.model.tree.maxsumbst_1373_0908;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :hard$
 * @date ��Created in 2021-10-07 17:17
 * @description��������������������ֵ��
 */

public class Solution {

    // �������Ժ������� 9.08

    /**
     * leetcode��1373�� ������������������ֵ��
     * @param root
     * @return
     */
    // ������������������ֵ��
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverseMaxSumBST(root);
        return maxSum;
    }

    /**
     * res[0]��¼��rootΪ���Ķ������Ƿ��� BST����Ϊ 1 ��˵���� BST����Ϊ 0 ��˵������ BST��
     *
     * res[1]��¼��rootΪ���Ķ��������нڵ��е���Сֵ��
     *
     * res[2]��¼��rootΪ���Ķ��������нڵ��е����ֵ��
     *
     * res[3]��¼��rootΪ���Ķ��������нڵ�ֵ֮�͡�
     * @param root
     * @return
     */

    int[] traverseMaxSumBST(TreeNode root){
        if(root == null){
            return new int[]{
                    1,Integer.MAX_VALUE,Integer.MIN_VALUE,0
            };
        }

        int[] left = traverseMaxSumBST(root.left);
        int[] right = traverseMaxSumBST(root.right);

        int[] res = new int[4];
        // ��� if ���ж��� root Ϊ���Ķ������ǲ��� BST
        if(left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]){
            //�ж���BST��
            res[0] = 1;

            // ������ root Ϊ������� BST ����Сֵ
            res[1] = Math.min(root.val,left[1]);

            // ������ root Ϊ������� BST �����ֵ
            res[2] = Math.max(root.val,right[2]);
            // ������ root Ϊ������� BST ���нڵ�֮��
            res[3] = root.val + left[3] + right[3];
            // ����ȫ�ֱ���
            maxSum = Math.max(maxSum,res[3]);
        }else {
            res[0] = 0;
        }
        return res;

    }

}
