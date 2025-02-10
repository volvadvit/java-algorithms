package com.volvadvit.tasks;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Have a sorted array.
 * Need to find 2 numbers whose sum is equal to the desired value.
 * <p/>
 * Implemented with:
 *  1) O(n^2) - iteration
 *  2) O(n) + HashSet to store values
 *  3) O(n*log(n)) - BTree
 *  4) O(n) - pointers
 */
public class SumTwoNumbersFromArrayToFindTarget {

    public static void main(String[] args) {
        final int[] first = {-1, 2, 5, 8};
        final int[] second = {-3, -1, 0, 2, 6};
        final int[] third = {2, 4, 5};
        final int[] fourth = {-9, -5, -2, -1, 1, 4, 9, 11};

        System.out.println(Arrays.toString(first) + " --> " + Arrays.toString(findNumbersPointers(first, 7)));
        System.out.println(Arrays.toString(second) + " --> " + Arrays.toString(findNumbersPointers(second, 6)));
        System.out.println(Arrays.toString(third) + " --> " + Arrays.toString(findNumbersPointers(third, 8)));
        System.out.println(Arrays.toString(fourth) + " --> " + Arrays.toString(findNumbersPointers(fourth, 3)));
    }

    /**
     * O(n^2)
     */
    private static int[] findNumbers(final int[] source, final int target) {
        // need to add checks for length < 2
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (target == source[j] + source[i]) {
                    return new int[]{source[i], source[j]};
                }
            }
        }
        return new int[0];
    }

    /**
     * O(n*log(n))
     * source must be sorted
     */
    private static int[] findNumbersTree(final int[] source, final int target) {
        for (int i = 0; i < source.length; i++) {
            int left = i + 1;
            int right = source.length - 1;
            int next = target - source[i];

            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (source[middle] == next) {
                    return new int[]{source[i], next};
                } else if (next > middle) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return new int[0];
    }

    /**
     * O(n)
     * Additional memory: O(n)
     */
    private static int[] findNumbersHashSet(final int[] source, final int target) {
        final HashSet<Integer> set = new HashSet<>();

        for (int j : source) {
            final int diff = target - j;
            if (set.contains(diff)) {
                return new int[]{j, diff};
            }
            set.add(j);
        }
        return new int[0];
    }

    /**
     * O(n)
     * source must be sorted
     */
    private static int[] findNumbersPointers(final int[] source, final int target) {
        int left = 0;
        int right = source.length - 1;

        while (left < right) {
            int next = source[left] + source[right];
            if (target == next) {
                return new int[]{source[left], source[right]};
            } else if (next > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}
