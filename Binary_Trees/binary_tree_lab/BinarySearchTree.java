package binary_tree_lab;

public class BinarySearchTree {
	public static void main(String args[]) {
		// add test cases here

	}

	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null)
			tree = new TreeNode(val);

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);

		if (dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	// preOrder, postOrder, and revOrder
	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void revOrder() {
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null) {
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight()))
			return 1 + getNumLevels(tree.getLeft());
		else
			return 1 + getNumLevels(tree.getRight());
	}

	// add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull
	public int getHeight() {
		return getHeight(root);
	}

	// height is 1 less than numLevels
	public int getHeight(TreeNode tree) {
		return getNumLevels(tree) - 1;
	}

	public int getWidth() {
		return getWidth(root);
	}

	/*
	 * Width, or diameter, is AT LEAST the sum of the heights of the left and right
	 * branches of root + 1 (to account for root). The width could also lie in one
	 * of the branches themselves, so the width of each branch must be compared.
	 */
	public int getWidth(TreeNode tree) {
		if (tree == null)
			return 0;
		return Math.max(getHeight(tree.getLeft()) + getHeight(tree.getRight()) + 1,
				Math.max(getWidth(tree.getLeft()), getWidth(tree.getRight())));
	}

	public int getNumLeaves() {
		return getNumLeaves(root);
	}

	// adds one for each node that has no children
	public int getNumLeaves(TreeNode tree) {
		if (tree.getLeft() == null && tree.getRight() == null)
			return 1;
		return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
	}

	public int getNumNodes() {
		return getNumNodes(root);
	}

	// add 1 for each node there is
	public int getNumNodes(TreeNode tree) {
		if (tree == null)
			return 0;
		return getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight()) + 1;
	}

	public boolean isFull() {
		return isFull(root);
	}

	// if numNodes = 2^numLevels - 1, tree is full
	public boolean isFull(TreeNode tree) {
		return Math.pow(2, getNumLevels(tree)) - 1 == getNumNodes(tree);
	}

	// add extra credit options here - 10 points each
	// search
	public boolean search(Comparable val, TreeNode tree) {
		if (tree != null) {
			int dirTest = val.compareTo(tree.getValue());
			if (dirTest == 0)
				return true;
			else if (dirTest < 0)
				return search(val, tree.getLeft());
			else if (dirTest > 0)
				return search(val, tree.getRight());
		}
		return false;
	}

	// maxNode
	public TreeNode getLargest() {
		return getLargest(root);
	}

	public TreeNode getLargest(TreeNode tree) {
		if (tree.getRight() == null)
			return tree;
		return tree.getRight();
	}

	// minNode
	public TreeNode getSmallest() {
		return getSmallest(root);
	}

	public TreeNode getSmallest(TreeNode tree) {
		if (tree.getLeft() == null)
			return tree;
		return tree.getLeft();
	}
}