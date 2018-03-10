package leetcode;

import java.util.LinkedList;
import java.util.List;


//https://leetcode.com/problems/partition-labels/description/
// bad solution.
public class PartitionLabels {

	private static class Boundary {
		char ch;

		boolean died = false;

		public Boundary(char ch, int l, int r) {
			this.left = l;
			this.right = r;
			this.ch = ch;
		}

		int left;
		int right;
	}

	private Boundary findBoundary(List<Boundary> list, Character ch) {
		for (Boundary boundary : list) {
			if (ch == boundary.ch) {
				return boundary;
			}
		}
		return null;
	}

	private Boundary findBoundary(List<Boundary> list, Boundary boundary) {
		for (Boundary boundary2 : list) {
			if (boundary2.died || boundary == boundary2) {
				continue;
			}
			if (boundary.left < boundary2.right && boundary.left > boundary2.left) {
				return boundary2;
			}
		}
		return null;
	}

	public List<Integer> partitionLabels(String S) {
		List<Boundary> list = new LinkedList<>();
		for (int i = 0; i < S.length(); i++) {
			Character character = S.charAt(i);
			Boundary boundary = findBoundary(list, character);
			if (boundary == null) {
				boundary = new Boundary(character, i, i);
				list.add(boundary);
			}
			if (boundary.right < i) {
				boundary.right = i;
			}
		}
		boolean mergingHappened = true;
		while (mergingHappened) {
			mergingHappened = false;
			for (Boundary boundary : list) {
				if (boundary.died) {
					continue;
				}
				Boundary mergeTo = findBoundary(list, boundary);
				if (mergeTo != null) {
					if (boundary.right > mergeTo.right) {
						mergeTo.right = boundary.right;
					}
					boundary.died = true;
					mergingHappened = true;
				}
			}
		}
		List<Integer> result = new LinkedList<>();
		for (Boundary boundary : list) {
			if (!boundary.died) {
				result.add(boundary.right - boundary.left + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = new PartitionLabels().partitionLabels("ab");
		for (Integer integer : result) {
			System.out.println(integer);
		}

	}

}
