package com.volvadvit.sort.Merge;

import java.util.Arrays;

/** Сортировка слиянием.
 *  Укороченная версия:
 *  int i=0, j=0, k=0;
 *  a3[k++] = a1[i] < a2[j] ? a1[i++] : a2 [j++]
 */
public class Merge {

    public static void main(String[] args) {
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        int[] result = sort(unsorted);
        System.err.println(Arrays.toString(result));
    }

    private static int[] sort(int[] input) {
        if (input.length < 2) {
            return input;
        }
        int[] rightHalf = Arrays.copyOfRange(input, 0, input.length/2);
        int[] leftHalf = Arrays.copyOfRange(input, input.length/2, input.length);

        rightHalf = sort(rightHalf);
        leftHalf = sort(leftHalf);
        return merge(rightHalf, leftHalf);
    }

    private static int[] merge(int[] right, int[] left) {
        int[] mergeArray = new int[right.length + left.length];

        int positionA = 0, positionB = 0;

        for (int i = 0; i < mergeArray.length; i++) {
            if (positionA == right.length) {
                mergeArray[i] = left[positionB];
                positionB++;
            } else if (positionB == left.length) {
                mergeArray[i] = right[positionA];
                positionA++;
            } else if (right[positionA] < left[positionB]) {
                mergeArray[i] = right[positionA];
                positionA++;
            } else {
                mergeArray[i] = left[positionB];
                positionB++;
            }
        }
        return mergeArray;
    }
}
