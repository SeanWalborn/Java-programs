// Name: Sean Walborn
// Lab 8, Problem 1
// Submission date: 10/26/25

/*
 *  the program reads data from a file and creates a binary tree using a linked list
 *  tree node class, in-order, pre-order, and post-order methods and class are provided
 *  z represents an empty node
 */

package Lab8;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.File;
import java.io.FileNotFoundException;


public class L8P1 {
	public static void main(String[] args) {
		// Variables
		String fileName = "";
		TreeNode root;
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
				
		// collecting file name
		System.out.print("Enter file name : ");
		fileName = scan.next();
		
		root = buildTree(fileName);
		
		// showing traversal
		System.out.print("Preorder Traversal  : ");
		preorder(root);
		System.out.println();
		System.out.print("Inorder Traversal   : ");
		inorder(root);
		System.out.println();
		System.out.print("Postorder Traversal : ");
		postorder(root);
		System.out.println();
		
		while(true) {
			String input;
			
			System.out.println();
			System.out.print("Enter node to find its parent ( or 'n' to quit): " );
			input = scan.next();
			
			if(input.equals("n")) {
				System.out.println("Exiting.");
				break;
			}
			
			String parent = findParent(root, input);
			
			// checking if parent is root or not found
			if (parent.equals("root")) {
				System.out.println( input + " is the root.");
			}else if (parent.equals("0"))
				System.out.println( input + " not found in the tree.");
			else{
				System.out.println("Parent of " + input + ": " + parent);
			}		
			
		}
		
		scan.close();
	}
	
	
	// constructs binary tree using a file name collected from the user
	public static TreeNode buildTree(String file) {
		TreeNode root = null;
		
		// loading file 
		try{
			// setting up scanner and file
			File customerFile = new File(file);
			Scanner scan2 = new Scanner(customerFile);
			
			// building tree
			while (scan2.hasNextLine()) {
				
				// Processing each line of the file for each node
				String currentLine = scan2.nextLine();
				String [] part = currentLine.split(" ");
							
				// setting up strings for node
				String parent = part[0];
				String leftChild = part[1];
				String rightChild = part[2];
				
				
				TreeNode leftC;
				TreeNode rightC;
				
				// setting up first level
				if(root == null) {
					// checking for z
					if (leftChild.equals("Z")) {
						leftC = null;
					}else {
						leftC = new TreeNode(leftChild, null, null);
					}
					if (rightChild.equals("Z")) {
						rightC = null;
					}else {
						rightC = new TreeNode(rightChild, null, null);	
					}
					
					root = new TreeNode(parent, leftC, rightC);
					
				}else {
					// finding parent to place in correct spot
					TreeNode temp = findNode(root, parent);
					
					// Ensuring z isn't saved
					if (!leftChild.equals("Z")) {
                        temp.setLeft(new TreeNode(leftChild, null, null));
                    }

                    if (!rightChild.equals("Z")) {
                        temp.setRight(new TreeNode(rightChild, null, null));
                    }
					
				}
				
				
			}
			scan2.close();
		}
		catch(FileNotFoundException e){
			System.out.print("File not Found");
			e.printStackTrace();
			
		}
		
		return root;
	}
	
	// finds parent node using queue
	public static TreeNode findNode(TreeNode root, String p) {
		    Queue<TreeNode> queue = new LinkedList<>();
		    queue.add(root);

		    while (!queue.isEmpty()) {
		        TreeNode node = queue.poll();

		        if (node.getData().equals(p)) {
		            return node;
		        }
		        if (node.getLeft() != null) {
		            queue.add(node.getLeft());
		        }

		        if (node.getRight() != null) {
		            queue.add(node.getRight());
		        }
		    }
		    
		    // if parent is not found
		    return null; 
		}
	
	// finds parent of specific string
	public static String findParent(TreeNode r, String c) {
		String child = "";
		
		// checking if string is root
		if (r.getData().equals(c)) {
	        child = "root";
	    }else {
	    	// checking for parent with queue
	    	Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(r);
	        boolean found = false;
	        
	        // loop checks entire tree
	        while (!queue.isEmpty() && !found) {
	            TreeNode node = queue.remove();

	            // checking left child
	            if (node.getLeft() != null) {
	                if (node.getLeft().getData().equals(c)) {
	                    child = node.getData();
	                    found = true;
	                    break;
	                } else {
	                    queue.add(node.getLeft());
	                }
	            }

	            // checking right child
	            if (node.getRight() != null) {
	                if (node.getRight().getData().equals(c)) {
	                    child = node.getData();
	                    found = true;
	                    break;
	                } else {
	                    queue.add(node.getRight());
	                }
	            }
	        }

	        // if parent is not found
	        if (!found) {
	            child = "0";
	        }
	    }
		
		return child;
	}
	
	
	//in-order traversal method
	public static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + " ");
			inorder(node.getRight());
		}
	}
	
	// post-order traversal method
	public static void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}
	
	// pre-order traversal method
	public static void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
}
