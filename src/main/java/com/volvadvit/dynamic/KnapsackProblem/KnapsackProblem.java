package com.volvadvit.dynamic.KnapsackProblem;

import java.util.ArrayList;
import java.util.List;

/** Имеется некий рюкзак с ограниченной вместимостью,
 *  И несколько предметов:{смоимость, вес}.
 *  Необходимо получить максимально возможную сумму стоимости предметов,
 *  Не превышая вместимость рюкзака.
 *
 *  Подход можно применять, для поиска соответствий в строках (автозамена слов)
 *
 *  cell[i][j] = Max.of(
 *      предыдущий максимум: cell[i-1][j]
 *                  OR
 *      стоимость текущего элемента + стоимость оставшегося места: cell[i][j] + cell[i-1][j-вес предмета]
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int bagCapacity = 4;
        int itemsCount = 3;

        /**  @param bagCells[row][col]:
         *  Так как вес предмета не может быть = 0, а индексы массива начинаются с 0,
         *   То добавим одну колонку к нашем bagCells,
         *   А первую колонку bagCells[...][0] оставим пустой.
         */
        int[][] bagCells = new int[itemsCount][bagCapacity + 1];

        List<Integer> itemsWeight = new ArrayList<>(List.of(1, 4, 3));
        List<Integer> itemsCost = new ArrayList<>(List.of(1500, 3000, 2000));

        int maxPossibleCost = searchMaxPossibleCost(bagCells, itemsWeight, itemsCost);
        System.err.println("Max possible cost: " + maxPossibleCost);
    }

    private static int searchMaxPossibleCost(int[][] bagCells, List<Integer> itemsWeight, List<Integer> itemsCost) {
        for (int i = 0; i < bagCells.length; i++) {
            for (int j = 1; j < bagCells[0].length; j++) {

                int currentMaxForCell = 0;
                if (itemsWeight.get(i) <= j) {
                    bagCells[i][j] = itemsCost.get(i);
                    if (((i - 1) >= 0) && (j - itemsWeight.get(i) > 0)) {
                        currentMaxForCell = bagCells[i][j] + bagCells[i-1][j-itemsWeight.get(i)];
                    } else {
                        currentMaxForCell = bagCells[i][j];
                    }
                }

                int lastMaxForCell = 0;
                if ((i - 1) >= 0) {
                    lastMaxForCell = bagCells[i-1][j];
                } else {
                    lastMaxForCell = bagCells[i][j];
                }

                bagCells[i][j] = Math.max(lastMaxForCell, currentMaxForCell);
                System.err.println("For item: " + itemsCost.get(i) + ". Cell: " + j + ". Cost = " + bagCells[i][j]);
            }
            System.err.println("\n");
        }
        return bagCells[itemsWeight.size() - 1][bagCells[0].length - 1];
    }
}
