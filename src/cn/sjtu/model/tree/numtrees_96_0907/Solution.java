package cn.sjtu.model.tree.numtrees_96_0907;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:13
 * @description����ͬ�Ķ���������
 */

public class Solution {

    //������ 9.06
    /**
     * leetcode 96��   ��ͬ�Ķ���������(BST)�Ĺ��������
     * @param n
     * @return
     */
    //����¼
    int[][] memory;
    public int numTrees(int n) {
        memory = new int[n+1][n+1];
        return count(1,n);
    }
    int count(int lo,int hi){
        //�����䣬����Ϊ1
        if(lo > hi){
            return 1;
        }
        //�鱸��¼
        if(memory[lo][hi] != 0){
            return memory[lo][hi];
        }

        int res  = 0;
        for(int i = lo; i<= hi; i++){
            //i��ֵ��Ϊ���ڵ� root
            int left = count(lo,i-1);
            int right = count(i+1,hi);
            res += left*right;
        }
        //��������뱸��¼
        memory[lo][hi] = res;
        return res;
    }


}
