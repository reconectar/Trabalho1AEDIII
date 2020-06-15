package util;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteForceQ4 {

    public static String getBiggestSubsetBruteForce(int array[]) {
        ArrayList<Integer> biggestSubset = new ArrayList<Integer>();
        ArrayList<Integer> subsequence = new ArrayList<Integer>();
        findBiggestSubset(biggestSubset, subsequence, array, 0);
        int result[] = new int[biggestSubset.size()];
        for (int i = 0; i < biggestSubset.size(); ++i) {
            result[i] = biggestSubset.get(i);
        }
        return Arrays.toString(result);
    }

    private static void findBiggestSubset(ArrayList<Integer> biggestSubset, ArrayList<Integer> subsequence, int array[], int i) {
        if (i == array.length) {
            if (checkIfSorted(subsequence) && subsequence.size() > biggestSubset.size()) {
                biggestSubset.clear();
                for (int v : subsequence) {
                    biggestSubset.add(v);
                }
            }
            return;
        }
        else {
            subsequence.add(array[i]);
            findBiggestSubset(biggestSubset, subsequence, array, i+1);
            subsequence.remove(subsequence.size() - 1);
            findBiggestSubset(biggestSubset, subsequence, array, i+1);
        }
    }

    private static boolean checkIfSorted(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); ++i) {
            if (arr.get(i) < arr.get(i-1)) {
                return false;
            }
        }
        return true;
    }

}
