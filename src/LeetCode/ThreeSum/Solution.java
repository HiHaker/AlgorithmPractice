package LeetCode.ThreeSum;

import java.util.*;

/**
 * Created on 2020/4/13 0013
 * BY Jianlong
 */
public class Solution {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        int a, b, c;
//        List<List<Integer>> ret = new ArrayList<>();
//        Set<String> check = new HashSet<>();
//
//
//        for ( int i=0; i<nums.length; i++){
//            int target = -nums[i];
//            HashMap<Integer, Integer> num = new HashMap<>();
//            for ( int j=i+1; j<nums.length; j++){
//                if (num.containsKey(target-nums[j])){
//                    a = nums[i];
//                    b = nums[j];
//                    c = target-nums[j];
//
//                    List<Integer> tuple = new ArrayList<>();
//
//                    if (a > b){
//                        if (a > c){
//                            if (b > c){
//                                tuple.add(c);
//                                tuple.add(b);
//                                tuple.add(a);
//                            } else{
//                                tuple.add(b);
//                                tuple.add(c);
//                                tuple.add(a);
//                            }
//                        } else{
//                            tuple.add(b);
//                            tuple.add(a);
//                            tuple.add(c);
//                        }
//                    } else{
//                        if (a > c) {
//                            tuple.add(c);
//                            tuple.add(a);
//                            tuple.add(b);
//                        } else{
//                            if (b > c){
//                                tuple.add(a);
//                                tuple.add(c);
//                                tuple.add(b);
//                            } else{
//                                tuple.add(a);
//                                tuple.add(b);
//                                tuple.add(c);
//                            }
//                        }
//                    }
//                    String s = tuple.get(0)+""+tuple.get(1)+""+tuple.get(2);
//                    if (!check.contains(s)){
//                        check.add(s);
//                        ret.add(tuple);
//                    }
//                }
//                num.put(nums[j], j);
//            }
//        }
//
//        return ret;
//    }

    public static List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> ret = threeSum(nums);
        for (List<Integer> temp:ret){
            for (int a:temp){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
