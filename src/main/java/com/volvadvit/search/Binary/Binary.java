package com.volvadvit.search.Binary;

public class Binary {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int searchFor = sortedArray[4];
        System.err.println("Search for: " + searchFor + ". Index, if exist: " + searchIndex(sortedArray , searchFor));
    }

    private static Integer searchIndex(int[] input, int searchFor) {
        int minIndex = 0;
        int maxIndex = input.length - 1;

        while(minIndex < maxIndex) {
            int mid = (minIndex + maxIndex) / 2;
            int guess = input[mid];

            if (guess == searchFor) {
                return mid;
            } else if (guess < searchFor) {
                    minIndex = guess + 1;
            } else {
                maxIndex = guess - 1;
            }
        }
        return null;
    }
}
