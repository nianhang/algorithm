package cn.sjtu.model.array.removeduplicates1_26_0925;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-25 12:06
 * @description��ɾ�����������е��ظ���
 */

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        //�ÿ���ָ����
        int slow = 0;
        int fast = 1;
        while(fast < n){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}

