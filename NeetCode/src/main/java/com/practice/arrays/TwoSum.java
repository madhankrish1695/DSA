package com.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *<p></p>
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 *<p></p>
 * Return the answer with the smaller index first.
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSumSorting(new int[]{4, 5, 6}, 10)));
        System.out.println(Arrays.toString(twoSum.twoSumSorting(new int[]{5, 5}, 10)));

        System.out.println(Arrays.toString(twoSum.twoSumMap(new int[]{4, 5, 6}, 10)));
        System.out.println(Arrays.toString(twoSum.twoSumMap(new int[]{5, 5}, 10)));
    }

    /**
     *
     * O(nlogn) and O(n) space
     */
    public int[] twoSumSorting(int[] nums, int target) {

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while(i<j){
            if(nums[i] + nums[j] == target){
                return new int[] {i , j};
            }else if (nums[i] + nums[j] < target){
                i++;
            }else if (nums[i] + nums[j] > target){
                j++;
            }
        }
        return new int[] {};
    }

    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer>  complimentMap = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if(complimentMap.containsKey(nums[i])){
                return new int[] {complimentMap.get(nums[i]),i};
            }
            complimentMap.put(target - nums[i], i);
        }
        return new int[] {};
    }
}
