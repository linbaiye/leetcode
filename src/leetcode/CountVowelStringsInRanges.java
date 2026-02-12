package leetcode;

import java.util.Set;

public class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int[] ret = new int[queries.length];
        int[] sums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int inc = vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1)) ? 1 : 0;
            if (i == 0) {
                sums[i] = inc;
            } else {
                sums[i] = sums[i - 1] + inc;
            }
        }
        for (int x = 0; x < queries.length; x ++) {
            int end = queries[x][1];
            int start = queries[x][0];
            if (start == 0) {
                ret[x] = sums[end];
            } else {
                ret[x] = sums[end] - sums[start - 1];
            }
        }
        return ret;
    }

}
