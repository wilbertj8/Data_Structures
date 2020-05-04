package assignments;
//(c) A+ Computer Science
// www.apluscompsci.com  

//searching for values in a tree

import static java.lang.System.*;

class BinarySearchTree3 {
	private TreeNode root;

	public BinarySearchTree3() {
		root = null;
	}

	public void add(Comparable val) {
		// call the add helper method
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null) {
			return new TreeNode(val, null, null);
		}
		int dirTest = val.compareTo(tree.getValue());
		if (dirTest < 0) // do I go left
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0) // do I go right
			tree.setRight(add(val, tree.getRight()));
		return tree;
	}

	public boolean contains(Comparable val) {
		// call the contains helper method
		return contains(val, root);
	}

	private boolean contains(Comparable val, TreeNode tree) {
		// add in the code to search the tree for a value
		if (tree != null) {
			int dirTest = val.compareTo(tree.getValue());
			// if val found in tree - stop and return true
			if (dirTest == 0)
				return true;
			// check the left side
			else if (dirTest < 0)
				return contains(val, tree.getLeft());
			// check the right side
			else if (dirTest > 0)
				return contains(val, tree.getRight());
		}
		return false;
	}

	public String inOrder() {
		// call the inOrder helper method
		return inOrder(root);
	}

	private String inOrder(TreeNode tree) {
		// write the inOrder helper method
		if (tree != null)
			return inOrder(tree.getLeft())
					+ tree.getValue() + " " +
					inOrder(tree.getRight());
		return "";
	}
}

public class Contains {
	public static void main(String args[]) {
		BinarySearchTree3 tree = new BinarySearchTree3();

		tree.add(90);
		tree.add(100);
		tree.add(80);
		tree.add(50);
		tree.add(110);
		tree.add(70);

		out.println("IN ORDER");
		System.out.println(tree.inOrder()); // outs 50 70 80 90 100 110

		out.println("\n");
		System.out.println(tree.contains(90)); // outs true
		System.out.println(tree.contains(110)); // outs true
		System.out.println(tree.contains(70)); // outs true
		System.out.println(tree.contains(21)); // outs false
		System.out.println(tree.contains(50)); // outs true
	}
}