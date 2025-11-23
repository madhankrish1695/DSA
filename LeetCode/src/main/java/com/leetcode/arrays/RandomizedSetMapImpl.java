package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class RandomizedSetMapImpl {

    Map<Integer, Integer> keyValueMap = new HashMap<>();
    Map<Integer, Integer> valueKeyMap = new HashMap<>();
    int count = 0;

    public static void main(String[] args) {
        RandomizedSetMapImpl randomizedSetMapImpl = new RandomizedSetMapImpl();
        System.out.println(randomizedSetMapImpl.insert(1));
        System.out.println(randomizedSetMapImpl.remove(2));
        System.out.println(randomizedSetMapImpl.insert(2));
        System.out.println(randomizedSetMapImpl.getRandom());
        System.out.println(randomizedSetMapImpl.remove(1));
        System.out.println(randomizedSetMapImpl.insert(2));
        System.out.println(randomizedSetMapImpl.getRandom());
    }

    public RandomizedSetMapImpl() {
        keyValueMap = new HashMap<>();
        valueKeyMap = new HashMap<>();
        count = 0;
    }

    public boolean insert(int val) {
        if (valueKeyMap.containsKey(val)) return false;
        keyValueMap.put(count, val);
        valueKeyMap.put(val, count);
        count++;
        return true;
    }

    public boolean remove(int val) {
        if (!valueKeyMap.containsKey(val)) return false;
        int index = valueKeyMap.get(val);
        int lastIndex = count - 1;
        int lastVal = keyValueMap.get(lastIndex);

        valueKeyMap.put(lastVal, index);
        keyValueMap.put(index, lastIndex);

        valueKeyMap.remove(val);
        keyValueMap.remove(lastIndex);
        count--;
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(count);
        return keyValueMap.get(index);
    }
}
