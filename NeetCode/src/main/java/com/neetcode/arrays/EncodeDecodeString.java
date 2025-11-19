package com.neetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 * </p>
 * Please implement encode and decode
 */
public class EncodeDecodeString {

    public static void main(String[] args) {
        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();

        List<String> strs1 = Arrays.asList("neet", "code", "love", "you");
        List<String> strs2 = Arrays.asList("we", "say", ":", "yes");

        System.out.println(encodeDecodeString.decode(encodeDecodeString.encode(strs1)));
        System.out.println(encodeDecodeString.decode(encodeDecodeString.encode(strs2)));
    }

    //O(m) time O(m+n) space
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String val : strs) {
            sb.append(val.length()).append("#").append(val);
        }
        return sb.toString();
    }

    //O(m) time O(m+n) space
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;

            result.add(str.substring(i, j));

            i = j;
        }

        return result;
    }
}
