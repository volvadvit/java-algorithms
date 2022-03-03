package com.volvadvit.sort.Count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Сортировка подсчетом.
 *
 *  Время  - O(n + m), Память - O(n + m),
 *  где m - max value in collection.
 *
 *  Создается массив от 0 до m, где в каждый индекс записывается,
 *  сколько раз в изначальном массиве встречается схожее с индексом число.
 *
 *  Считается устойчивой.
 *
 *  Application: В ситуациях, когда различия в разнообразии ключевых значений не значительно превосходит количество элементов.
 */
public class Count {

    public static void main(String[] args) {
        // Set Up
        int[] unsorted = createStartArrayWithLength(50);
        int maxValue = getMaxFromArray(unsorted);

        System.err.println("Array = " + Arrays.toString(unsorted) + "\n Max value = " + maxValue);
        System.err.println(countSort(unsorted, maxValue));
    }

    private static List<Integer> countSort(int[] unsorted, int max) {
        // Fill count's array
        int[] countArray = new int[max + 1];
        Arrays.fill(countArray, 0);
        for (int num : unsorted) {
            countArray[num]++;
        }

        // Fill result list
        List<Integer> result = new ArrayList<>();
        for (int num = 0; num < countArray.length; num++) {
            for (int i = 0; i < countArray[num]; i++) {
                result.add(num);
            }
        }
        return result;
    }

    private static int getMaxFromArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    private static int[] createStartArrayWithLength(int length) {
        int[] ar = new int[length];
        for (int i = 0; i < length; i++) {
            ar[i] = (int) (Math.random() * 100);
        }
        return ar;
    }
}
