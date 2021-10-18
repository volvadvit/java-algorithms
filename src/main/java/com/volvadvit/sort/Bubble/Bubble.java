package com.volvadvit.sort.Bubble;

import java.util.Arrays;

/** Сортировка Пузырьком.
 * Уже оптимизированна под меньшее количество итераций в конце,
 * так как самые большие элементы собираются с конца.
 */
public class Bubble {

    public static void main(String[] args) {
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        System.err.println(Arrays.toString(bubbleSort(unsorted)));
    }

    private static int[] bubbleSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j+1]) {
                    swap(input, j, j+1);
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
