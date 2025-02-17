package com.volvadvit.tasks;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicaesFromArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int takeFirstIndexes = removeDuplicates(nums);
        System.out.println("Expected = [1,2,_], Actual = " + Arrays.toString(nums) + ", result = " + takeFirstIndexes);
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        takeFirstIndexes = removeDuplicates(nums);
        System.out.println("Expected = [0,1,2,3,4,_,_,_,_,_], Actual = " + Arrays.toString(nums) + ", result = " + takeFirstIndexes);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;

        int newIdx = 1;
        int prevValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prevValue) {
                prevValue = nums[i];
                nums[newIdx++] = nums[i];
            }
        }

        return newIdx;
    }
}
