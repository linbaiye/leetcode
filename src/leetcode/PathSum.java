package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
    public void dump() {
    	System.out.println("val: " + val);
    	if (left != null) {
    		left.dump();
    	}
    	if (right != null) {
    		right.dump();
    	}
    }
}



public class PathSum {
	
	private boolean doCheckPathSum(TreeNode node, int sum, int current) {
		if (node.val + current == sum && node.left == null && node.right == null) {
			return true;
		}
		boolean found = false;
		if (node.left != null) {
			found = doCheckPathSum(node.left, sum, node.val + current);
		}
		if (found) {
			return found;
		}
		if (node.right != null) {
			found = doCheckPathSum(node.right, sum, node.val + current);
		}
		return found;
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return doCheckPathSum(root, sum, 0);
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node.left = node2;
		System.out.println(new PathSum().hasPathSum(node, 1));
	}

}
