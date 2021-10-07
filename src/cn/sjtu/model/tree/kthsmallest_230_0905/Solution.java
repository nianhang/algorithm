package cn.sjtu.model.tree.kthsmallest_230_0905;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:04
 * @description�������������е�KС��Ԫ��
 */

public class Solution {

    //��������������һ�ڣ�
    /**
     * leetCode ��230�� �����������е�KС��Ԫ��
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
        // �����������λ��
        rank++;
        if(k == rank){
            // �ҵ��� k С��Ԫ��
            resTree = root.val;
            return;
        }
        traverseTree(root.right,k);
    }

}
