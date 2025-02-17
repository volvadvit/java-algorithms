package com.volvadvit.tasks;

import java.util.Arrays;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int takeFirstIndexes = removeElement(nums, 3);
        System.out.println("Expected = [2,2,_,_], Actual = " + Arrays.toString(nums) + ", result = " + takeFirstIndexes);
        nums = new int[]{0,1,2,2,3,0,4,2};
        takeFirstIndexes = removeElement(nums, 2);
        System.out.println("Expected = [0,1,4,0,3,_,_,_], Actual = " + Arrays.toString(nums) + ", result = " + takeFirstIndexes);
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
