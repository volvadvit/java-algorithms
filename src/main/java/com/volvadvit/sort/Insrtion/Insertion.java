package com.volvadvit.sort.Insrtion;

import java.util.Arrays;

/** Сортировка Вставкой.
 *
 *  Время O(n^2) - среднем/худшем, в лучшем O(n),
 *
 *  Считается устойчивой.
 *
 * Вместо создания нового отсортированного массива,
 * значения будут хранится в отсортированном подмассиве в начале массива.
 * Берется любой элемент и вставляется на нужное место в подмассив.
 *
 * Application: Small lists and limited memory, best with already sorted array or close-to-sorted array.
 *              Practically more efficient comparing to bubble sort and selection sort.
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
            int j = i - 1;
            while (j >= 0 && current < input[j]) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = current;
        }
        return input;
    }

    private static void swap(int[] input, int indexFirst, int indexSecond) {
        input[indexFirst] = input[indexFirst] ^ input[indexSecond];
        input[indexSecond] = input[indexFirst] ^ input[indexSecond];
        input[indexFirst] = input[indexFirst] ^ input[indexSecond];
    }
}
