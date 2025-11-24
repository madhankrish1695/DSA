package com.leetcode.arrays;

public class FirstOccurrence {

    public static void main(String[] args) {
        FirstOccurrence firstOccurrence = new FirstOccurrence();
//        System.out.println(firstOccurrence.strStr1("sadbutsad", "but"));
//        System.out.println(firstOccurrence.strStr1("leetcode", "leeto"));
        System.out.println(firstOccurrence.strStr2("a", "a"));
//        System.out.println(firstOccurrence.strStr2("leetcode", "leeto"));
//        System.out.println(firstOccurrence.strStr3("sadbutsad", "but"));
//        System.out.println(firstOccurrence.strStr3("leetcode", "leeto"));
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
