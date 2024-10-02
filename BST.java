package src;
/*
Program name: BST.java
Programmer: Xavier Ramos
Date: 9-30-2024
Version: 1.0
Description - Binary Search Tree
Methods -
 + Insert
 + InOrder
 + Delete
*/


public class BST {
	private Node root;
	
	public void BinarySearchTree() {
		this.root = null;
	}
	
	
//AUX METHODS
//AUX methods are essential to implement since you only input is key instead of root node and key
	public void insert(int key) {
		root = insertAux(root, key);
	}  
	public Node search(int key) {
		return searchAux(root, key);
	}
	
	public void inorder() {
		if (root != null) {
			inorderAux(root);
		}
	}
	
	public void delete(int key) {
		root = deleteNodeAux(root, key);
	}
	
	
//METHODS
	
	
//SEARCH METHOD
	
	public Node searchAux(Node root, int key){
		//If tree is empty OR root.key is the same as the key
		if(root == null || root.key == key){
			return root;
		}
		
		//If root key is less than key search right subtree
		if(root.key < key) {
			return searchAux(root.right, key);
		}
		//ELSE search left subtree
		else {
			return searchAux(root.left, key);
		}
	
	}
	
	
//INSERT METHOD
	
	public Node insertAux(Node root, int key) {
		//If tree is empty make a new node
		if(root == null) {
			return new Node(key);
		}
		
		//If key is present in tree,
		//return root
		if(root.key == key) {
			return root;
		}
		
		//key is less than root.key then go to left subtree
		if(key < root.key) {
			//Recursive call to go all left subtree
			root.left = insertAux(root.left, key);
		}
		
		else {
			//Recursive call to go to all right subtree
			root.right = insertAux(root.right, key);
		}
		return root;
	}

	
//INORDER METHOD
	
	public void inorderAux(Node root) {
		//Checks if tree is empty
		if(root != null) {
			//Drills down all the way to the left subtree
			inorderAux(root.left);
			
			//Processes the root.key to show we've visited it
			System.out.print(root.key + " ");
			
			//Drills down all the way to the left subtree
			inorderAux(root.right);
		}
	}
	
	
//DELETION METHOD
	
	public Node deleteNodeAux(Node root, int delVal) {
		//Base Case
		if(root == null) {
			return root;
		}
		
		//Checks left and right subtree for value
		if(root.key > delVal) {
			root.left = deleteNodeAux(root.left, delVal);
		}
		else if(root.key < delVal) {
			root.right = deleteNodeAux(root.right, delVal);
		}
		
		else {
			//Once Value is found
			//If Node has no child, return null
			if(root.left == null && root.right == null) {
				return null;
			}
			
			//If Node has no left node, return right
			else if(root.left == null) {
				return root.right;
			}
			
			//If Node has no right node, return left
			else if(root.right == null) {
				return root.left;
			}
			else {
			
				Node succ = getSuccessor(root); //Gets Inorder Successor 
				root.key = succ.key; //replaces key with successor key
				root.right = deleteNodeAux(root.right, succ.key); //Deletes successor
			}
		}
		
		return root;
	}
	
	
//METHOD TO GET SUCCESSOR(next node)
	
	public Node getSuccessor(Node curr) {
		//Start with right subtree, since successor is always in right
        curr = curr.right;
        
    
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }  
	
//MAIN METHOD
	
	public static void main(String[]args){
		BST tree = new BST();

		tree.insert(47);
		tree.insert(43);
		tree.insert(23);
		tree.insert(90);
		tree.insert(95);
		tree.insert(27);
		tree.insert(67);
		tree.insert(80);
		tree.insert(88);
		tree.insert(29);
		tree.insert(59);
		tree.insert(24);
		tree.insert(69);
		tree.insert(44);
		tree.insert(71);
		tree.insert(61);
		tree.insert(99);
		tree.insert(42);
		tree.insert(38);
		
		System.out.println("Inorder Traversal of Binary Search Tree #1: ");
		tree.inorder();
		System.out.println("\nAfter Deletion:");
		
		tree.delete(27);
		tree.delete(38);
		tree.delete(44);
		tree.delete(95);
		tree.delete(88);
		tree.delete(59);
		tree.inorder();
		System.out.println("\n");
		
		
		BST tree2 = new BST();
		tree2.insert(17);
		tree2.insert(15);
		tree2.insert(49);
		tree2.insert(34);
		tree2.insert(76);
		tree2.insert(59);
		tree2.insert(97);
		tree2.insert(69);
		tree2.insert(46);
		tree2.insert(86);
		tree2.insert(20);
		tree2.insert(99);
		tree2.insert(22);
		tree2.insert(52);
		tree2.insert(89);
		tree2.insert(57);
		tree2.insert(10);
		
		System.out.println("\nInorder Traversal of Binary Search Tree #2: ");
		
		tree2.inorder();
		
		System.out.println("\nAfter Deletion:");
		tree2.delete(99);
		tree2.delete(22);
		tree2.delete(69);
		tree2.delete(15);
		tree2.delete(10);
		tree2.delete(75);
		
		tree2.inorder();
	}
}

