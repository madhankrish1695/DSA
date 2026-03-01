package com.leetcode.trie;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and
 * retrieve keys in a dataset of strings. There are various applications of this data structure,
 * such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and
 * false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix,
 * and false otherwise
 */
public class Trie {

    private TrieNode root = null;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode end = searchNode(word);
        return null != end && end.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return null != searchNode(prefix);
    }

    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (current.trieNodes[index] == null) {
                return null;
            }
            current = current.trieNodes[index];
        }
        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        // Test search
        System.out.println("Search 'apple': " + trie.search("apple"));     // true
        System.out.println("Search 'app': " + trie.search("app"));         // true
        System.out.println("Search 'appl': " + trie.search("appl"));       // false
        System.out.println("Search 'bat': " + trie.search("bat"));         // true
        System.out.println("Search 'bad': " + trie.search("bad"));         // false

        // Test startsWith
        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true
        System.out.println("StartsWith 'ba': " + trie.startsWith("ba"));   // true
        System.out.println("StartsWith 'cat': " + trie.startsWith("cat"));
    }

}


class TrieNode {
    TrieNode[] trieNodes;
    boolean isEndOfWord;

    public TrieNode() {
        trieNodes = new TrieNode[26];
        isEndOfWord = false;
    }
}
