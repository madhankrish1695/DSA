package com.leetcode.arrays;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class RandomizedSetListImpl {

    private Map<Integer, Integer> valToIndex;
    //List is preferred over map since it consumes less memory and no overhead of caching
    private List<Integer> values;
    private Random rand;

    public static void main(String[] args) {
        RandomizedSetListImpl randomizedSetListImpl = new RandomizedSetListImpl();
        System.out.println(randomizedSetListImpl.insert(1));
        System.out.println(randomizedSetListImpl.remove(2));
        System.out.println(randomizedSetListImpl.insert(2));
        System.out.println(randomizedSetListImpl.getRandom());
        System.out.println(randomizedSetListImpl.remove(1));
        System.out.println(randomizedSetListImpl.insert(2));
        System.out.println(randomizedSetListImpl.getRandom());
    }

    public RandomizedSetListImpl() {
        valToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) return false;
        valToIndex.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) return false;
        int index = valToIndex.get(val);
        int lastElement = values.get(values.size() - 1);

        // Swap val with the last element (O(1) removal)
        values.set(index, lastElement);
        valToIndex.put(lastElement, index);

        // Remove last element
        values.remove(values.size() - 1);
        valToIndex.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(values.size());
        return values.get(randomIndex);
    }
}
