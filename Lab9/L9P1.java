// Name: Sean Walborn
// Lab 9, Problem 1
// Submission date: 11/09/25

/*
 *  - collect file of numbers from user and create a binary search tree from the numbers 
 *  - display the binary search tree in preorder, inorder, and post order
 *  - display the height and size of the tree
 *  - allow user to search for a number
 *  - display the input level, if its a root or leaf, and if its not in the tree
 *  - asks user to repeat search for new number
 *  - treeNode class is provided
 *  - traversal methods manipulated from previous lab
 */


package Lab9;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class L9P1 {
	public static void main(String[] args) {
		// Variables 
		String fileName = "";
		TreeNode root;
		int height = 0;
		int size = 0;
		String runAgain = "y";
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting file name
		System.out.print("Enter file name: " );
		fileName = scan.next();
		System.out.println();
		
		// opening file and building search tree
		root = buildTree(fileName);
		
		// showing traversal results
		System.out.println("Tree traversal result");
		System.out.print("Preorder  : ");
		preorder(root);
		System.out.println();
		System.out.print("Inorder   : ");
		inorder(root);
		System.out.println();
		System.out.print("Postorder : ");
		postorder(root);
		System.out.println();
		System.out.println();
		 
		// find the tree height and size
		height = findHeight(root);
		size = findSize(root);
		
		// displaying height and size of tree
		System.out.println("Height of tree : " + height);
		System.out.println("Size of tree : " + size);
		System.out.println();
		
		// running data search until user ends program
		while(runAgain.equals("y")) {
			// local variables
			int searchData = 0;
			
			// collecting user data to search
			System.out.print("Enter data to search : ");
			searchData = scan.nextInt();
			
			// searching tree
			searchTree(root, searchData, 0);
			
			// asking if user want to do another search
			System.out.print("More (y/n) : ");
			runAgain = scan.next();
			System.out.println();
		}
		
		scan.close();
		
	}
	
	// helper methods declared and defined: 
	// helper method that opens a file and builds a BST when provided a file name 
	public static TreeNode buildTree(String file) {
		// setting up tree
		TreeNode root = null;
		
		//loading file
		try {
			// setting up new scanner and file
			File treeFile = new File(file);
			Scanner scan2 = new Scanner(treeFile);
			
			// building Binary Search Tree
			while(scan2.hasNextLine()){
				
				// processing each number
				int current = scan2.nextInt();
				
				// sets up root of tree
				if (root == null) {
					root = new TreeNode(current, null, null);
				}else {
					
					// recursive method to find proper position for each node
					placeInt(root, current);
				}
			}
			
			scan2.close();
		}
		catch(FileNotFoundException e) {
			System.out.print("File Not Found");
			e.printStackTrace();
		}
		
		return root;
		
		
	}
	
	// used to place the current data in the correct spot of the BST
	public static void placeInt(TreeNode node, int data) {
		// check whether to go right or left
		if (data > node.data) {
			// base case if null is encountered in the right direction
			if(node.rchild == null) {
				node.rchild = new TreeNode(data, null, null);
			}else {
				placeInt(node.rchild, data);
			}
		}else if (data < node.data) {
			//base case if null is encountered moving left
			if(node.lchild == null) {
				node.lchild = new TreeNode(data, null, null);
			}else {
				placeInt(node.lchild, data);
			}
		}
		// does nothing if term is equal to a node 	
	}
	
	// find the size of the tree
	public static int findSize(TreeNode node) {
		// uses in order traversal structure
		if (node == null) {
			return 0;
		}else {
			return (1 + findSize(node.lchild) + findSize(node.rchild));
		}			
	}
	
	// finds the height of the tree 
	public static int findHeight(TreeNode node) {
		// uses in order traversal structure
		if (node == null) {
			return -1;
		}else {
			// returns whichever side is larger
			if (findHeight(node.lchild) > findHeight(node.rchild)) {
				return (1 + findHeight(node.lchild));
			}else {
				return (1 + findHeight(node.rchild));
			}
		}	
	}
	
	// searches for data in tree prints location, type, or not present
	public static void searchTree(TreeNode node, int data, int level) {
		// base case if data if found
		if (node.data == data) {
			// determine if root or leaf
			if (level == 0) {
				System.out.println(data + " is a root at level 0");
			}else if (node.lchild == null && node.rchild == null){
				System.out.println(data + " is at level " + level + " and " + data + " is a leaf node");
			}else {
				System.out.println(data + " is at level " + level);
			}
		} else if (node.lchild == null && node.rchild == null) { // base case if data is not in the tree
			System.out.println(data + " is not in tree");
		} else if (data > node.data) { // moves to the right of the node
			searchTree(node.rchild, data, level + 1);
		} else { // moves to the left of the node
			searchTree(node.lchild, data, level + 1);
		}
		
	}
	
	//in-order traversal method using recursion
	public static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.lchild);
			System.out.print(node.data + " ");
			inorder(node.rchild);
		}
	}
	
	// post-order traversal method using recursion
	public static void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.lchild);
			postorder(node.rchild);
			System.out.print(node.data + " ");
		}
	}
	
	// pre-order traversal method using recursion
	public static void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.lchild);
			preorder(node.rchild);
		}
	}
}
