package cn.sjtu.model.tree.countnode_222_0911;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-11 18:28
 * @description��
 */

public class CompleteBinaryTree {

    //һ���������ڵ����
    public int countNodesNormal(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodesNormal(root.left) + countNodesNormal(root.right);
    }

    //��������
    public int countNodesPerfect(TreeNode root) {
        int h = 0;
        while(root != null){
            root = root.left;
            h++;
        }
        return (int)Math.pow(2,h) - 1;
    }

    //��ȫ������
    public int countNodesComplete(TreeNode root) {

        TreeNode left = root;
        TreeNode right = root;

        int highLeft = 0;
        int highRight = 0;

        while(left != null){
            left = left.left;
            highLeft++;
        }
        while(right != null){
            right = right.right;
            highRight++;
        }
        // ������������ĸ߶���ͬ������һ����������
        if(highLeft == highRight){
            return (int)Math.pow(2,highLeft) - 1;
        }
        // ������Ҹ߶Ȳ�ͬ��������ͨ���������߼�����
        return 1 + countNodesComplete(root.left) + countNodesComplete(root.right);
    }




}
