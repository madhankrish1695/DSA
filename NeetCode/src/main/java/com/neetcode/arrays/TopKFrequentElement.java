package com.neetcode.arrays;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 * </p>
 * The test cases are generated such that the answer is always unique.
 * </p>
 * You may return the output in any order.
 */
public class TopKFrequentElement {
    public static void main(String[] args) {
        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();

        int[] nums1 = new int[]{1, 2, 2, 3, 3, 3};
        int k1 = 2;

        int[] nums2 = new int[]{7, 7};
        int k2 = 1;

        System.out.println(Arrays.toString(topKFrequentElement.topKFrequentHeap(nums1, k1)));
        System.out.println(Arrays.toString(topKFrequentElement.topKFrequentHeap(nums2, k2)));

        System.out.println(Arrays.toString(topKFrequentElement.topKFrequentBucketSort(nums1, k1)));
        System.out.println(Arrays.toString(topKFrequentElement.topKFrequentBucketSort(nums2, k2)));
    }

    //O(nlogk) time and O(n+k) space
    public int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[0] = b[0];
        });

        frequencyMap.entrySet().forEach(entry -> {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        });

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[1];
        }
        return result;
    }

    //O(n) time and O(n) space
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] frequencyCount = new List[nums.length + 1];

        for (int i = 0; i < frequencyCount.length; i++) {
            frequencyCount[i] = new ArrayList<>();
        }

        frequencyMap.entrySet().forEach(entry -> {
            frequencyCount[entry.getValue()].add(entry.getKey());
        });

        int[] result = new int[k];
        int index = 0;

        for (int i = frequencyCount.length - 1; i > 0 && index < k; i--) {
            for (int num : frequencyCount[i]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
