package cn.sjtu.model.tree.codec_297_0909;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;

/**
 * @author ��linfd
 * @version :hard$
 * @date ��Created in 2021-10-07 17:19
 * @description�� �����������л��뷴���л�
 */

public class Codec {


    //���������⣬���Ǽ�����ܣ���������  9.09

    /**
     * leetcode ��297�� �����������л��뷴���л�
     * @param root
     * @return
     */

    //ǰ�����
    // Encodes a tree to a single string.
    String SEP = ",";
    String NULL = "#";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    /* ���������������������� StringBuilder */
    void serialize(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        /****** ǰ�����λ�� ******/
        sb.append(root.val).append(SEP);
        /***********************/

        serialize(root.left,sb);
        serialize(root.right,sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* ����������ͨ�� nodes �б�������� */
    TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;
        /****** ǰ�����λ�� ******/
        // �б��������Ǹ��ڵ�
        String first = nodes.removeFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }



    //��������
    // Encodes a tree to a single string.
    public String serializeLast(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeLast(root,sb);
        return sb.toString();
    }
    /* ���������������������� StringBuilder */
    void serializeLast(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        serialize(root.left,sb);
        serialize(root.right,sb);

        /****** ǰ�����λ�� ******/
        sb.append(root.val).append(SEP);
        /***********************/
    }


    // Decodes your encoded data to tree.
    public TreeNode deserializeLast(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deserializeLast(nodes);
    }

    /* ����������ͨ�� nodes �б�������� */
    TreeNode deserializeLast(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;

        /****** ǰ�����λ�� ******/
        // �б����Ҳ���Ǹ��ڵ�
        String last = nodes.removeLast();
        if(last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        /***********************/
        // �޹���������������������
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

}
