package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
 * <p>
 * Each letter in pattern maps to exactly one unique word in s.
 * Each unique word in s maps to exactly one letter in pattern.
 * No two letters map to the same word, and no two words map to the same letter.
 */
public class WordPattern {

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish"));
    }

    //O(N) Time and O(N) space
    public boolean wordPattern(String pattern, String s) {

        String[] wordArray = s.split(" ");

        if (pattern.length() != wordArray.length) return false;

        Map<Character, String> patterWordMap = new HashMap<>();
        Map<String, Character> wordPatternMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Character patternChar = pattern.charAt(i);
            String word = wordArray[i];
            if (patterWordMap.containsKey(patternChar)) {
                if (!patterWordMap.get(patternChar).equals(word)) return false;
            } else if (wordPatternMap.containsKey(word)) {
                if (!wordPatternMap.get(word).equals(patternChar)) return false;
            }

            patterWordMap.put(patternChar, word);
            wordPatternMap.put(word, patternChar);
        }

        return true;
    }
}
