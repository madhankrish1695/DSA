package com.leetcode.arrays;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
 */
public class GasStation {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(gasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) return -1;

        int start = 0;
        int currentGas = 0;

        for (int i = 0; i < n; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = start + 1;
            }
        }

        return start;
    }
}
