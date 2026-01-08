package com.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<Integer> numberAlreadySeen = new HashSet<>();
        while (n != 1 && !numberAlreadySeen.contains(n)) {
            numberAlreadySeen.add(n);
            int sum = 0;
            while (n != 0) {
                int mod = n % 10;
                sum += mod * mod;
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
