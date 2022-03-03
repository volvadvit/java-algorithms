package com.volvadvit.sort.Radix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** LSD Поразрядная сортировка.
 *
 *  Время : Worst – O(n * b), Best – O(n).
 *  Доп.память - O(n + b)
 *
 *  где b - in base (система счисления).
 *
 *  Считается неустойчивой.
 *
 *  (num % mod) / div;
 * 	xx1 = (input % 10) / 1;
 * 	x1x = (input % 100) / 10;
 * 	1xx = (input % 1000) / 100;
 */

public class RadixLSD {

    private static final int rang = 10; // For digits 0..9

    public static void main(String[] args) {
        List<Integer> unsorted = List.of(
                22, 17, 1, 2, 110, 60, 21, 18, 235, 3, 14, 153, 24, 5, 91, 10, 19, 44, 20, 74, 12, 131, 8, 25);
        System.err.println(radixSort(unsorted));
    }

    private static List<Integer> radixSort(List<Integer> input) {
        // Количетсво разрядов у самого большого числа
        int maxNumberLength = Collections.max(input).toString().toCharArray().length;
        List<Integer> resultList = new ArrayList<>(input.size());
        resultList.addAll(List.copyOf(input));

        int mod = 10;
        int div = 1;

        // Sort
        for (int i = 0; i < maxNumberLength; i++) {
            List<List<Integer>> buckets = createBucketsList(rang); // Temp list 10xN

            for (Integer num : resultList) {
                int radix = (num % mod) / div;
                buckets.get(radix).add(num);
            }

            resultList = new ArrayList<>();
            for (List<Integer> rangList : buckets) {
                resultList.addAll(rangList);
            }
            mod *= 10;
            div *= 10;
        }
        return resultList;
    }

    private static List<List<Integer>> createBucketsList(int rang) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < rang; i++) {
            buckets.add(new ArrayList<>());
        }
        return buckets;
    }
}
