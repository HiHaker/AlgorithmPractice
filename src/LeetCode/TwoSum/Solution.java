package LeetCode.TwoSum;

/**
 * Created on 2020/4/13 0013
 * BY Jianlong
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        for ( int i=0; i<nums.length; i++){
            int gap = target - nums[i];
            for (int j=i+1; j<nums.length; j++){
                if (nums[j] == gap){
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }

        return ret;
    }
}
