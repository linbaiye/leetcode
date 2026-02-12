package leetcode;

import java.util.HashSet;
import java.util.Set;

public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        Set<Integer> least = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    least.add(Math.min(nums[i], nums[j]));
                }
            }
        }
        return least.size();
    }
}
