package com.leetcode.graphBFS;

import java.util.*;

/**
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * <p>
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 * <p>
 * Given the two gene strings startGene and endGene and the gene bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 * <p>
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        MinimumGeneticMutation solution = new MinimumGeneticMutation();
        int result = solution.minMutation(startGene, endGene, bank);

        System.out.println("Minimum mutations: " + result);
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (startGene.equals(endGene)) return 0;
        if (!bankSet.contains(endGene)) return -1;
        int count = 0;
        char[] geneChar = {'A', 'C', 'G', 'T'};
        Queue<String> geneQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        geneQueue.offer(startGene);
        visited.add(startGene);
        while (!geneQueue.isEmpty()) {
            int size = geneQueue.size();
            for (int k = 0; k < size; k++) {
                String current = geneQueue.poll();
                if (current.equals(endGene)) return count;

                char[] geneArr = current.toCharArray();
                for (int i = 0; i < geneArr.length; i++) {
                    char curChar = geneArr[i];
                    for (char c : geneChar) {
                        if (c != curChar) {
                            geneArr[i] = c;
                            String newGene = new String(geneArr);

                            if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                                geneQueue.offer(newGene);
                                visited.add(newGene);
                            }
                        }
                    }
                    geneArr[i] = curChar;
                }
            }
            count++;
        }
        return -1;
    }
}
