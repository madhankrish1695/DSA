package com.leetcode.twopointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindromeWithoutInBuild("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        String validStr = s.replaceAll("[^a-zA-z0-9]", "").toLowerCase();
        return new StringBuilder(validStr).reverse().toString().equals(validStr);
    }

    public boolean isPalindromeWithoutInBuild(String s) {
        if (null == s) return false;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
