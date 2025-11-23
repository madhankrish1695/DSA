package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> romanIntegerMap = new HashMap<>();
        romanIntegerMap.put('I', 1);
        romanIntegerMap.put('V', 5);
        romanIntegerMap.put('X', 10);
        romanIntegerMap.put('L', 50);
        romanIntegerMap.put('C', 100);
        romanIntegerMap.put('D', 500);
        romanIntegerMap.put('M', 1000);

        int result = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Integer current = romanIntegerMap.get(s.charAt(i));
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }
}
