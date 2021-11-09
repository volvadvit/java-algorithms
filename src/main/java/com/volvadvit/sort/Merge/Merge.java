package com.volvadvit.sort.Merge;

import java.util.Arrays;

/** Сортировка слиянием.
 *
 * Время - O(n * log(n)). Доп. память - O(n).
 *
 * Считается устойчивой.
 *
 *  Укороченная версия:
 *  int i=0, j=0, k=0;
 *  ar3[k++] = ar1[i] < ar2[j] ? ar1[i++] : ar2 [j++]
 */
public class Merge {

    public static void main(String[] args) {
        int[] unsorted = {22, 17, 1, 2, 11, 6, 21, 18, 23, 3, 14, 15, 24, 5, 9, 10, 19, 4, 20, 7, 12, 13, 8, 25};
        int[] result = sort(unsorted);
        System.err.println(Arrays.toString(result));
    }

    private static int[] sort(int[] input) {
        // Делим начальный массив на парные подмассивы, с 1 элементом
        // После чего складваем каждую пару, параллельно сортируя элементы
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

        // Текущий индекс правого и левого подмассивов
        int positionRight = 0, positionLeft = 0;

        for (int i = 0; i < mergeArray.length; i++) {
            if (positionRight == right.length) {
                // Если из правого подмассива выбраны уже все элементы
                mergeArray[i] = left[positionLeft];
                positionLeft++;
            } else if (positionLeft == left.length) {
                // Если из левого подмассива выбраны уже все элементы
                mergeArray[i] = right[positionRight];
                positionRight++;
            } else if (right[positionRight] < left[positionLeft]) {
                // Сортировка по возрастанию
                mergeArray[i] = right[positionRight];
                positionRight++;
            } else {
                mergeArray[i] = left[positionLeft];
                positionLeft++;
            }
        }
        return mergeArray;
    }
}
