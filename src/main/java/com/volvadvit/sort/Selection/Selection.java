package com.volvadvit.sort.Selection;

import java.util.Arrays;

/** Сортировка Выбором.
 * Ищется минимальный (максимальный) элемент в неотсортированном подмассиве,
 * и вставляется в конец (начало) отсортированного подмассива,
 * в начало (конец) массива.
 */
public class Selection {

    public static void main(String[] args) {
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        System.err.println(Arrays.toString(selectionSort(unsorted)));
    }

    private static int[] selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int minValueIndex = i;

            // search minValue in unsorted sub-array
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            // swap min value and first value, in unsorted sub-array
            if (minValueIndex != i) {
                swap(input, minValueIndex, i);
            }
        }
        return input;
    }

    private static void swap(int[] input, int indexFirst, int indexSecond) {
        input[indexFirst] = input[indexFirst] ^ input[indexSecond];
        input[indexSecond] = input[indexFirst] ^ input[indexSecond];
        input[indexFirst] = input[indexFirst] ^ input[indexSecond];
    }
}
