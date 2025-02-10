package com.volvadvit.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the number of subarrays whose sum of elements is equal to the desired number
 *
 * Solutions:
 * 1, 2) Iterations
 * 3) Prefix sums (HashMap)
 */
public class FindNumbersOfSubarrayIsEqualsTarget {

    public static void main(String[] args) {
        // Answer 5
        final int[] source = {4, 2, 2, 1, 2, -3, 5, -8};

        System.out.println("O(n^3) --> " + findSubarraySlow(source, 5));
        System.out.println("O(n^2) --> " + findSubarrayIteration(source, 5));
        System.out.println("O(n) --> " + findSubarrayPrefixSum(source, 5));
    }

    /**
     * O(n^3)
     */
    private static int findSubarraySlow(int[] source, int target) {
        int result = 0;
        for (int i = 0; i < source.length; i++) {
            int subarraySum = 0;
            for (int j = i; j < source.length; j++) {
                for (int k = i; k < j + 1; k++) {
                    subarraySum += source[k];
                    if (subarraySum == target) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * O(n^2)
     */
    private static int findSubarrayIteration(int[] source, int target) {
        int result = 0;
        for (int i = 0; i < source.length; i++) {
            int subarraySum = 0;
            for (int j = i; j < source.length; j++) {
                subarraySum += source[j];
                if (subarraySum == target) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * O(n) + memory O(n)
     */

    private static int findSubarrayPrefixSum(int[] source, int target) {
        int result = 0;
        int subarraySum = 0;
        final HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        for (int j : source) {
            subarraySum += j;
            int toRemove = subarraySum - target;
            result += map.getOrDefault(toRemove, 0);
            int prefixSum = map.getOrDefault(subarraySum, 0);
            map.put(subarraySum, prefixSum + 1);
        }
        return result;
    }
}
