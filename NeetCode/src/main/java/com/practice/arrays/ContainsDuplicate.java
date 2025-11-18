package com.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,2,3};

        System.out.println(containsDuplicate.hasDuplicate(nums1));
        System.out.println(containsDuplicate.hasDuplicate(nums2));
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int i : nums){
            if(!numSet.add(i)){
                return true;
            }
        }
        return false;
    }
}
