package com.leetcode.trie;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 */
public class WordDictionary {

    TrieNode root = null;

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        System.out.println("Search 'pad': " + dictionary.search("pad")); // false
        System.out.println("Search 'bad': " + dictionary.search("bad")); // true
        System.out.println("Search '.ad': " + dictionary.search(".ad")); // true
        System.out.println("Search 'b..': " + dictionary.search("b..")); // true
        System.out.println("Search '..d': " + dictionary.search("..d")); // true
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (current.trieNodes[index] == null) {
                current.trieNodes[index] = new TrieNode();
            }
            current = current.trieNodes[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        if (node == null) return false;

        if (index == word.length()) {
            return node.isEndOfWord;
        }

        if ('.' == word.charAt(index)) {
            for (TrieNode child : node.trieNodes) {
                if (null != child) {
                    boolean isPresent = dfs(word, index + 1, child);
                    if (isPresent) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int idx = word.charAt(index) - 'a';
            if (node.trieNodes[idx] == null) {
                return false;
            }
            return dfs(word, index + 1, node.trieNodes[idx]);
        }
    }
}
