package project1;
import java.util.Scanner;
class Node 
{ 
	int key; 
	Node left, right; 

	public Node(int item) 
	{ 
		key = item; 
		left = right = null; 
	} 
} 

public class BinaryTree 
{
	Node root; 

	BinaryTree() 
	{ 
		root = null; 
	} 
	void printPostorder(Node node) 
	{ 
		if (node == null) 
			return; 

		printPostorder(node.right);
		
		printPostorder(node.left); 

		if(node.left==null&&node.right==null)
		System.out.print(node.key + " "); 
	} 

	void printPostorder() {	 printPostorder(root); } 

	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements");
		int N=sc.nextInt(),i;
		
		int ar[]=new int[N];

		System.out.println("Enter the elements");
		
		for(i=0;i<N;i++) {
			ar[i]=sc.nextInt();
		}
		
		tree.root=new Node(ar[0]);
		for(i=1;i<N;i++) {
			makeTree(tree,ar[i]);
		}
		
		System.out.println("\nLeaves of the tree from right to left are- "); 
		tree.printPostorder(); 
	} 
	
	static void makeTree(BinaryTree tree,int el) {
		Node current=tree.root;
		
		while(true) {
			if(el<current.key) {
				if(current.left==null) {
					current.left=new Node(el);
					System.out.println("Inserted "+el+" at left of "+current.key);
					break;
				}
				else
				current=current.left;
			}
			else {
				if(current.right==null) {
				current.right=new Node(el);
				System.out.println("Inserted "+el+" at right of "+current.key);
				break;
			}
			else
				current=current.right;
			}
		}
	}
} 
