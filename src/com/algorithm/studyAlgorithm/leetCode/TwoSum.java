package com.algorithm.studyAlgorithm.leetCode;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i=0; i<nums.length-1; i++){

            for(int j=i+1; j<nums.length; j++){

                if(target == nums[i]+nums[j]){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] output = twoSum.twoSum(nums, target);
        for(int out: output){
            System.out.print(out + " ");
        }
    }
}
