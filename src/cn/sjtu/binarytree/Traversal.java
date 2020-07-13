package cn.sjtu.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		
		/*preOrderTraverse1(t1);
		System.out.println();
		preOrderTraverse2(t1);
		System.out.println();
		
		inOrderTraverse1(t1);
		System.out.println();
		inOrderTraverse2(t1);
		System.out.println();*/
		
		
		postOrderTraverse1(t1);
		System.out.println();
		postOrderTraverse2(t1);
		System.out.println();
		
		/*levelOrder1(t1);
		System.out.println();
		levelOrder2(t1);*/
		//System.out.println(depth(t1));
		//System.out.println(depth1(t1));
		
		
	}
	
	
	
	//�ݹ�汾�ı���
	
	public static void preOrderTraverse1(TreeNode root){
		
		if(root == null){
			return ;
		}
		System.out.print(root.val+" ");
		preOrderTraverse1(root.left);
		preOrderTraverse1(root.right);
		
	}
	
	public static void inOrderTraverse1(TreeNode root){
		
		if(root == null){
			return ;
		}
		inOrderTraverse1(root.left);
		System.out.print(root.val+" ");
		inOrderTraverse1(root.right);
		
	}
	
	public static void postOrderTraverse1(TreeNode root){
		if(root == null){
			return ;
		}
		postOrderTraverse1(root.left);
		postOrderTraverse1(root.right);
		System.out.print(root.val+" ");
	}
	
	//��α���
	public static void levelOrder1(TreeNode root){
		
		if(root == null){
			return;
		}
		
		int depth = depth(root);
		
		for(int i = 0;i <= depth;i++){
			levelOrder(root, i);
		}
			
	}
	
	public static void levelOrder(TreeNode root,int level){
		
		if(root == null || level < 1){
			return;
		}
		if(level == 1){
			System.out.print(root.val+" ");
			return;
		}
		levelOrder(root.left, level-1);
		levelOrder(root.right, level-1);
	}
	
	//��߶�
	public static int depth(TreeNode root){
		
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		return (left>right)?left+1:right+1;
	}
	

	//�ǵݹ����
		
    //ǰ���������ѹ��ջ�еĴ�ӡ˳��
	public static void preOrderTraverse2(TreeNode root){
		
		if(root == null){
			return;
		}
		
		TreeNode pNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(pNode != null || !stack.isEmpty()){

			if(pNode != null){
				stack.add(pNode);
				System.out.print(pNode.val+" ");
				pNode = pNode.left;
			}else{
				TreeNode node = stack.pop();
				pNode = node.right;
			}
		
		}
		
	}
	
	//����������ǵ���ջ��˳��
	public static void inOrderTraverse2(TreeNode root){
		
		if(root == null){
			return;
		}
		
		TreeNode pNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(pNode != null || !stack.isEmpty()){
			
			if(pNode != null){
				stack.add(pNode);
				pNode = pNode.left;
			}else{
				TreeNode  node = stack.pop();
				System.out.print(node.val+" ");
				pNode = node.right;
			}
	
		}

	}
	
	//��������������ջ����ʾ��Ȼ�����ұ�����һ��ջ��ʾ��ӡ��˳��һ��ջ��ʾ����˳��
	public static void postOrderTraverse2(TreeNode root){
		
		if(root == null){
			return ;
		}
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		TreeNode pNode = root;
		
		while(pNode != null || !stack1.isEmpty()){
			
			if(pNode != null){
				stack1.push(pNode);
				stack2.push(pNode);
				pNode = pNode.right;//�Ȱ��ұߵ�ѹ��ջ��
			}else{
			    TreeNode node = stack1.pop();
				pNode = node.left;//��������ߵ�ѹ��ջ��
			}
		
		}
		
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().val+" ");
		}
		
	
	}
	
	//��α���
	public static void levelOrder2(TreeNode root){
		
		if(root == null){
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			
			TreeNode pNode = queue.poll();//��ȡ���Ƴ��˶��е�ͷ
			System.out.print(pNode.val + " ");
			
			if(pNode.left != null){//��ڵ㲻Ϊ��
				queue.offer(pNode.left);//��ָ����Ԫ�ز���˶��У�������������Ҳ���Υ���������ƣ���
										//��ʹ�����������ƵĶ���ʱ���˷���ͨ��Ҫ���� add(E)�����߿����޷�����Ԫ�أ���ֻ���׳�һ���쳣��
			}
			
			if(pNode.right != null){//�ҽڵ㲻Ϊ��
				queue.offer(pNode.right);
			}
			
		}

	}
	
	//�ǵݹ���߶�
	//���ò�α������㷨�����ñ���level��¼��ǰ�ڵ����ڵĲ��������ñ���lastָ��ǰ������һ���ڵ㣬
	//�������굱ǰ������һ���ڵ㣬��levelָ��+1���������ñ���cur��¼��ǰ���Ѿ����ʵĽڵ�ĸ�������cur����lastʱ����ʾ�ò���ʽ�����
	public static int depth1(TreeNode root){
		
		if(root == null){
			return 0;
		}
		
		int level = 0;
		int cur,last;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			
			cur = 0;//��¼�����Ѿ������Ľڵ���� 
			last = queue.size();//�������굱ǰ���Ժ󣬶�����Ԫ��ȫ����һ���Ԫ�أ����еĳ�������һ��Ľڵ�ĸ���  
			
			while(cur < last){//����û�б������������һ���ڵ�ʱѭ��  
				TreeNode pNode = queue.poll();//����һ��Ԫ��  
				cur++;
				//�ѵ�ǰ�ڵ�����ҽڵ���ӣ�������ڵĻ��� 
				if(pNode.left != null){
					queue.offer(pNode.left);
					
				}
				
				if(pNode.right != null){
					queue.offer(pNode.right);
				}
			}
			level++;

		}
		
		return level;
	}
	


}
