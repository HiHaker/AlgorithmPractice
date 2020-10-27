package LeetCode.FourSum;

import java.util.*;

/**
 * @Description FourSum
 * @Author Jianlong
 * @Date 2020-10-25 下午 20:23
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4){
            return result;
        }

        // 排序
        Arrays.sort(nums);

        int len = nums.length;

        // 维护存储已经遍历过的元素的集合，防止遍历相同的元素
        Set<Integer> listA = new HashSet<>();
        Set<Integer> listB;
        Set<Integer> listC;

        A:for (int a=0; a<len-3; a++){

            // 剪枝
            if (nums[a] + nums[a+1] + nums[a+2] + nums[a+3] > target) {
                break;
            }

            if (nums[a] + nums[len-1] + nums[len-2] + nums[len-3] < target) {
                continue;
            }

            // 如果是相同的元素，跳过
            if (listA.contains(nums[a])){
                continue;
            }
            else{
                listA.add(nums[a]);
            }

            listB = new HashSet<>();

            B:for (int b=a+1; b<len-2; b++){

                // 剪枝
                if (nums[a] + nums[b] + nums[b+1] + nums[b+2] > target){
                    break;
                }

                if (nums[a] + nums[b] + nums[len-1] + nums[len-2] < target){
                    continue;
                }

                // 如果是相同的元素，跳过
                if (listB.contains(nums[b])){
                    continue;
                }
                else{
                    listB.add(nums[b]);
                }

                listC = new HashSet<>();

                // 第四个数的指针
                int d = len-1;

                C:for (int c=b+1; c<len-1; c++){

                    // 如果是相同的元素，跳过
                    if (listC.contains(nums[c])){
                        continue;
                    }
                    else{
                        listC.add(nums[c]);
                    }

                    // 保证c指针在d指针的左边
                    while (c < d && nums[a] + nums[b] + nums[c] + nums[d] > target){
                        d--;
                    }

                    // 两个指针重合时，继续遍历
                    if (c == d){
                        break;
                    }

                    // 满足条件
                    if (nums[a] + nums[b] + nums[c] + nums[d] == target){
                        List<Integer> solution = new ArrayList<>();
                        solution.add(nums[a]);
                        solution.add(nums[b]);
                        solution.add(nums[c]);
                        solution.add(nums[d]);
                        result.add(solution);
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        new Solution().fourSum(nums, 0);
    }
}
