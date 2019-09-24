package CCF;

import java.util.Scanner;

/**
 * Created on 2019/9/14 0014
 * BY Jianlong
 * 题目地址：image/MinMidBig
 */
public class MinMidBig {
    public static void main(String[] args) {
        int num,min,mid,max;
        String[] nums;
        Scanner in = new Scanner(System.in);

        num = Integer.parseInt(in.nextLine());
        nums = in.nextLine().split(" ");
        min = Integer.parseInt(nums[0]);
        max = Integer.parseInt(nums[nums.length - 1]);

        if (min > max){
            mid = min;
            min = max;
            max = mid;
        }

        if (nums.length % 2 == 0){
            mid = (Integer.parseInt(nums[nums.length/2]) + Integer.parseInt(nums[nums.length/2-1]))/2;
        } else{
            mid = Integer.parseInt(nums[nums.length/2]);
        }

        System.out.print(max + " " + mid + " " + min);
    }
}