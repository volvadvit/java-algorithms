package com.volvadvit.tasks;

import java.util.Arrays;

class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2,5,6}, 3);
        System.out.println("Expected = [1,2,2,3,5,6], Actual = " + Arrays.toString(nums1));
        nums1 = new int[]{0};
        merge(nums1, 0, new int[]{1}, 1);
        System.out.println("Expected = [1], Actual = " + Arrays.toString(nums1));
        nums1 = new int[]{1};
        merge(nums1, 1, new int[]{}, 0);
        System.out.println("Expected = [1], Actual = " + Arrays.toString(nums1));
        nums1 = new int[]{4,5,6,0,0,0};
        merge(nums1, 3, new int[]{1,2,3}, 3);
        System.out.println("Expected = [1,2,3,4,5,6], Actual = " + Arrays.toString(nums1));
        nums1 = new int[]{4,0,0,0,0,0};
        merge(nums1, 1, new int[]{1,2,3,5,6}, 5);
        System.out.println("Expected = [1,2,3,4,5,6], Actual = " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int rigth = m - 1;
        int left = n - 1;
        int index = m + n - 1;

        while (left >= 0) {
            if (rigth >= 0 && nums1[rigth] > nums2[left]) {
                nums1[index] = nums1[rigth];
                rigth--;
            } else {
                nums1[index] = nums2[left];
                left--;
            }
            index--;
        }
    }
}
