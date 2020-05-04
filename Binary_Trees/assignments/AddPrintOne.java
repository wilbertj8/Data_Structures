package assignments;
//(c) A+ Computer Science
// www.apluscompsci.com  

//add and print tree example

import static java.lang.System.*;

class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		// check for null
		if (tree == null)
			return new TreeNode(val, null, null);
		int dirTest = val.compareTo(tree.getValue());
		// do you go left
		if (dirTest < 0)
			tree.setLeft(add(val, tree.getLeft()));
		// do you go right
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	// inOrder is a private helper method
	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}
}

public class AddPrintOne {
	public static void main(String args[]) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.add(100);
		tree.add(90);
		tree.add(80);
		tree.add(70);

		out.println("IN ORDER");
		tree.inOrder(); /// outs 50 70 80 90 100 110
	}
}