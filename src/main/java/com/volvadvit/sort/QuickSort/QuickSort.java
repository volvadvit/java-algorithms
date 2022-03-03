package com.volvadvit.sort.QuickSort;

import java.util.Arrays;

/** Быстрая сортирвока.
 *
 * В лучшем, среднем случае - O(n * log(n)). В худшем - O(n^2).
 * Память - O(log(n)).
 * Не устойчива (при доп. памяти O(n) можно сделать устойчивой).
 *
 * Application: Large lists, best when pivot divide in 2 equal halves.
 *            Not efficient for linked lists (poor pivot choice because of no random access).
 *           Generally outperform merge sort for sorting RAM-based arrays.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        quickSort(unsorted, 0, unsorted.length-1);
        System.err.println(Arrays.toString(unsorted));
    }

    private static void quickSort(int[] input, int inputIndexStart, int inputIndexEnd) {
        if (input.length != 0 && inputIndexStart < inputIndexEnd) {

            // Выбирается опорный элемент, относительно которого будут делиться два подмассива
            // Обычно это середина входного массива
            int mid = input[(inputIndexStart + inputIndexEnd) / 2];
            // Выставляются два флага с концов массива,
            // которые будут двигаться навстречу друг другу, до опорного элемента
            int left = inputIndexStart;
            int right = inputIndexEnd;

            while (left < right) {
                // Сортируем относительно опорного элемента
                while (input[left] < mid) {
                    left++;
                }
                while (input[right] > mid) {
                    right--;
                }
                if (left < right) {
                    swap(input, left, right);
                }
                left++;
                right--;
            }
            // left, right == mid
            // Сортируем каждый подмассив внутри себя
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
