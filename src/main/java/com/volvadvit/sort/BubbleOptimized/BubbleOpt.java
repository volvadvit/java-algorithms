package com.volvadvit.sort.BubbleOptimized;

import java.util.Arrays;

/** Оптимизированная Сортировка Пузырьком.
 * Позволяет не совершать лишних итераций цикла,
 * Если масив уже отсортирован.
 *
 * Как и в обычной сортировке,
 * цикл for с каждым разом уменьшает количество итераций,
 * через "- iterations".
 */
public class BubbleOpt {

    private static int iterations = 0;

    public static void main(String[] args) {
        // for 25 numbers - 16 iterations, because some of them are already sorted.
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        System.err.println(Arrays.toString(bubbleSort(unsorted)));
        // 1 iterations for already sorted array
        unsorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.err.println(Arrays.toString(bubbleSort(unsorted)));
    }

    private static int[] bubbleSort(int[] input) {
        boolean wasSwapped = true;

        while (wasSwapped) {
            wasSwapped = false;
            iterations++;

            for (int j = 0; j < input.length - iterations; j++) {
                if (input[j] > input[j+1]) {
                    swap(input, j, j + 1);
                    wasSwapped = true;
                }
            }
        }
        System.err.println("Count of iterations: " + iterations);
        return input;
    }

    private static void swap(int[] input, int indexFirst, int indexSecond) {
        input[indexFirst] = input[indexFirst] ^ input[indexSecond];
        input[indexSecond] = input[indexFirst] ^ input[indexSecond];
        input[indexFirst] = input[indexFirst] ^ input[indexSecond];
    }
}
