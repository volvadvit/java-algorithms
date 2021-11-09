package com.volvadvit.sort.QuickSort;

import java.util.Arrays;

/** Быстрая сортирвока.
 *
 * В лучшем, среднем случае - O(n * log(n)). В худшем - O(n^2).
 * Не устойчива (при доп. памяти O(n) можно сделать устойчивой).
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        quickSort(unsorted, 0, unsorted.length-1);
        System.err.println(Arrays.toString(unsorted));
    }

    private static void quickSort(int[] input, int inputIndexStart, int inputIndexEnd) {
        if (input.length != 0 && inputIndexStart < inputIndexEnd) {

            int prop = input[(inputIndexStart + inputIndexEnd) / 2]; // Опорный элемент
            int left = inputIndexStart;
            int right = inputIndexEnd;

            while (left < right) {
                while (input[left] < prop) {
                    left++;
                }
                while (input[right] > prop) {
                    right--;
                }
                if (left < right) {
                    swap(input, left, right);
                }
                left++;
                right--;
            }
            // left, right == prop
            if (inputIndexStart < right) { quickSort(input, inputIndexStart, right); }
            if (inputIndexEnd > left) { quickSort(input, left, inputIndexEnd); }
        }
    }

    private static void swap(int[] input, int indexFirst, int indexSecond) {
        int temp = input[indexSecond];
        input[indexSecond] = input[indexFirst];
        input[indexFirst] = temp;
    }
}
