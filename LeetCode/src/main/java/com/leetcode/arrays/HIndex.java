package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 */
public class HIndex {

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex1(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex.hIndex1(new int[]{1, 3, 1}));
        System.out.println(hIndex.hIndex2(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex.hIndex2(new int[]{1, 3, 1}));
    }

    // O(nlogn) O(1)
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) return h;
        }
        return 0;
    }

    // O(nlogn) O(n)
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }

        int papers = 0;

        for (int i = n; i >= 0; i--) {
            papers += count[i];
            if (papers >= i) {
                return i;
            }
        }

        return 0;
    }

}
