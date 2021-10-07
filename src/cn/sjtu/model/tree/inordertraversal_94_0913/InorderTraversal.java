package cn.sjtu.model.tree.inordertraversal_94_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-12 21:39
 * @description���������
 */

public class InorderTraversal {
    public static void main(String[] args) {

    }

    //�ݹ�
    List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;
        if(root.left != null){
            inorderTraversal(root.left);
        }

        res.add(root.val);

        if(root.right != null){
            inorderTraversal(root.right);
        }

        return res;
    }

    //����
    public List<Integer> inorderTraversalIteration(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        //����һ��ջstack������Ϊ����������м�ڵ�
        Stack<TreeNode> stack = new Stack<>();
        //��ǰ�ڵ㲻Ϊ�գ�����ջ��Ϊ��
        while(!stack.isEmpty() || root != null){
            //�������е���ڵ���
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            //�������е��ҽڵ���
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;
            }
        }
        return result;
    }




}
