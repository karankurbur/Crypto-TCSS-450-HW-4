//Karan Kurbur
//1435177 CSE 342

public class BinarySearchTree {
	public static Node root;

	public BinarySearchTree() { // Constructor
		this.root = null;
	}

	public boolean search(int id) {
		Node current = root;
		while (current != null) {
			if (current.key == id) {
				return true;
			} else if (current.key > id) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void insert(int id) {
		Node newNode = new Node(id);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (id < current.key) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	private int HeightUtil(Node root) {
		if (root == null)
			return -1;
		else
			return 1 + Math.max(HeightUtil(root.left), HeightUtil(root.right));
	}

	public double height() { // Compute the height of Binary Search
		return HeightUtil(root);
	}

	public void InorderTraversal() {
		inOrderHelper(root);
	}

	private void inOrderHelper(Node root) {
		if (root != null) {
			inOrderHelper(root.left);
			// System.out.print(root.key + " ");
			inOrderHelper(root.right);
		}
	}

	public static int getRand() {
		int max = (int) (Math.pow(2, 32) - 1);
		long random = (int) (Math.random() * max + 1);
		int signChange = (int) (Math.random() * 2 + 1);
		if (signChange == 2) {
			random = random * -1;
			int minusOne = (int) (Math.random() * 2 + 1); // To include the
															// smallest value
															// -2^32
			if (minusOne == 2) {
				random = random - 1;
			}
		}
		return (int) random;
	}

	public static double logOfBase(int base, int num) {
		return Math.log(num) / Math.log(base);
	}

	public static void main(String arg[]) {
		Integer[] nodeSize = { 10, 100, 500, 1000, 5000, 10000, 100000, 1000000 };
		for (Integer a : nodeSize) {
			BinarySearchTree bst = new BinarySearchTree();
			for (int i = 0; i < a; i++) {
				bst.insert(getRand());
			}
			bst.InorderTraversal();
			System.out.println("This tree with has a height of " + bst.height());
			System.out.println("This tree with has these many nodes " + a);
			System.out.println("LOG2(N) is " + (logOfBase(2, a)));
			double ratio = bst.height() / logOfBase(2, a);
			System.out.println("The ratio between height and log2n is " + ratio);
			System.out.println();
			// This follows the pattern of the number of nodes = 2^h. Since
			// these trees are not exactly balanced, our ratio will not be exactly 2 but they are very close.
			
		}
	}
}
