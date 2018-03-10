package leetcode;

// https://leetcode.com/problems/maximum-binary-tree/
public class MaximumBinaryTree {
	
	private int findMaxIndex(int[] nums, int start, int end) {
		int max = start;
		for (int i = start + 1; i < end; i++) {
			if (nums[max] < nums[i]) {
				max = i;
			}
		}
		return max;
	}

	public TreeNode constructSubTree(int[] nums, int start, int end) {
		int maxIndex = findMaxIndex(nums, start, end);
		TreeNode node = new TreeNode(nums[maxIndex]);
		if (start < end) {
			if (start != maxIndex) {
				node.left = constructSubTree(nums, start, maxIndex);
			}
			if (end != maxIndex + 1) {
				node.right = constructSubTree(nums, maxIndex + 1, end);
			}
		}
		return node;
	}

    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	return constructSubTree(nums, 0, nums.length);
    }
    
    
	
	public static void main(String[] args) {
		//int[] nums = {3,2,1,6,0,5};
		int[] nums = {0, 1};
		TreeNode node = new MaximumBinaryTree().constructMaximumBinaryTree(nums);
		node.dump();
	}

}
