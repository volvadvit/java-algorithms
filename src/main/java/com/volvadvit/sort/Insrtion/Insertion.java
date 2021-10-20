package com.volvadvit.sort.Insrtion;

import java.util.Arrays;

/** Сортировка Вставкой.
 *
 *  *  Время O(n^2),
 *  *  Считается устойчивой.
 *
 * Вместо создания нового отсортированного массива,
 * значения будут хранится в отсортированном подмассиве в начале массива.
 * Берется любой элемент и вставляется на нужное место в подмассив.
 */
public class Insertion {

    public static void main(String[] args) {
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        System.err.println(Arrays.toString(insertionSort(unsorted)));
    }

    private static int[] insertionSort(int[] input) {
        for (int i = 1; i < input.length - 1; i++) {

            // Берется элемент из неотсортированного подмассива
            int current = input[i];

            // Ищется место в отсортированном подмассиве
            for (int j = 0; j < i; j++) {
                if (input[j] > current) {
                    swap(input, i, j);
                }
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
