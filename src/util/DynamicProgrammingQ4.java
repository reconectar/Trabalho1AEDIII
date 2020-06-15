package util;

import java.util.Arrays;
import java.util.LinkedList;

public class DynamicProgrammingQ4 {

    public static String getBiggestSubsetDynamicProgramming(int[] arr) {
        LinkedList<SubsetQ4> subsets = new LinkedList<SubsetQ4>();
        for (int v : arr) {
            int maxLength = 0;
            SubsetQ4 biggestSubSet = null;
            for (SubsetQ4 subset : subsets) {
                if (subset.value <= v) {
                    if (subset.size > maxLength) {
                        maxLength = subset.size;
                        biggestSubSet = subset;
                    }
                }
            }
            SubsetQ4 newSubset = new SubsetQ4();
            newSubset.previous = biggestSubSet;
            newSubset.value = v;
            newSubset.size = 1 + (biggestSubSet != null ? biggestSubSet.size : 0);
            subsets.add(newSubset);

            for (SubsetQ4 subset : subsets) {
                while (subset != null) {
                    subset = subset.previous;
                }
            }
        }

        // Encontrando o maior subset.
        int maxLength = 0;
        SubsetQ4 biggestSubset = null;
        for (SubsetQ4 subset : subsets) {
            if (subset.size > maxLength) {
                maxLength = subset.size;
                biggestSubset = subset;
            }
        }

        // Convertendo ArrayList para array int[]
        int result[] = new int[biggestSubset.size];
        for (int i = result.length - 1; i >= 0; --i) {
            result[i] = biggestSubset.value;
            biggestSubset = biggestSubset.previous;
        }
        return Arrays.toString(result);
    }
}
