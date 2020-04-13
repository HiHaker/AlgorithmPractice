package LeetCode.ThreeSum;

import java.util.*;

/**
 * Created on 2020/4/13 0013
 * BY Jianlong
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        int a, b, c;
        List<List<Integer>> ret = new ArrayList<>();
        Set<String> check = new HashSet<>();


        for ( int i=0; i<nums.length; i++){
            int target = -nums[i];
            HashMap<Integer, Integer> num = new HashMap<>();
            for ( int j=i+1; j<nums.length; j++){
                if (num.containsKey(target-nums[j])){
                    a = nums[i];
                    b = nums[j];
                    c = target-nums[j];

                    List<Integer> tuple = new ArrayList<>();

                    if (a > b){
                        if (a > c){
                            if (b > c){
                                tuple.add(c);
                                tuple.add(b);
                                tuple.add(a);
                            } else{
                                tuple.add(b);
                                tuple.add(c);
                                tuple.add(a);
                            }
                        } else{
                            tuple.add(b);
                            tuple.add(a);
                            tuple.add(c);
                        }
                    } else{
                        if (a > c) {
                            tuple.add(c);
                            tuple.add(a);
                            tuple.add(b);
                        } else{
                            if (b > c){
                                tuple.add(a);
                                tuple.add(c);
                                tuple.add(b);
                            } else{
                                tuple.add(a);
                                tuple.add(b);
                                tuple.add(c);
                            }
                        }
                    }
                    String s = tuple.get(0)+""+tuple.get(1)+""+tuple.get(2);
                    if (!check.contains(s)){
                        check.add(s);
                        ret.add(tuple);
                    }
                }
                num.put(nums[j], j);
            }
        }

        return ret;
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
