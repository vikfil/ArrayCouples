package com.viktor;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayCouple {

    /**
     * Method is filtering data by checking if each pair of integers, [k, k+1], [k+2, k+3], etc.
     * in the array has a corresponding reversed pair somewhere else in the array
     * @param arr  An array of an even number of positive integers
     * @return  string "yes" if {@param arr} contain all pairs with their reversed pairs
     * or string of the integer pairs that are incorrect in the order that they appear in the array
     */
    public String arrayChallenge(int[] arr) {
        Set<Pair> pairSet = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i += 2) {
            pairSet.add(new Pair(arr[i], arr[i + 1]));
        }
        Set<Pair> setWithoutReversedPair = pairSet.stream()
                                                  .filter(pair -> !pairSet.contains(new Pair(pair.getY(), pair.getX())) || pair.getX() == pair.getY())
                                                  .collect(Collectors.toCollection(LinkedHashSet::new));

        return setWithoutReversedPair.isEmpty() ? "yes" : buildStringFromSet(setWithoutReversedPair);
    }

    private String buildStringFromSet(Set<Pair> set) {
        StringBuilder builder = new StringBuilder();
        for (Pair pair : set) {
            builder.append(pair.getX());
            builder.append(",");
            builder.append(pair.getY());
            builder.append(",");
        }
        return builder.deleteCharAt(builder.length()-1).toString();
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 1, 4, 5, 4, 4, 1};
        System.out.println(new ArrayCouple().arrayChallenge(arr1));
    }
}
