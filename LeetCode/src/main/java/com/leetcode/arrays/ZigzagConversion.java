package com.leetcode.arrays;

public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 3));
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] rowArray = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rowArray[i] = new StringBuilder();
        }
        int rowIndex = 0;
        int flip = 1;
        for (int i = 0; i < s.length(); i++) {
            rowArray[rowIndex].append(s.charAt(i));
            if (rowIndex == numRows - 1) flip = -1;
            else if (rowIndex == 0) flip = 1;
            rowIndex += flip;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            result.append(rowArray[i]);
        }

        return result.toString();
    }
}
