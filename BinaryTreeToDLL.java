
public class BinaryTreeToDLL {

	public static class Node{
		int data ;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void printList(Node node){
		while(node != null){
			System.out.print(node.data+ " -> ");
			node = node.left;
		}
		System.out.println("\n Reverse");
		while(node != null){
			System.out.print(node.data+ " -> ");
			node = node.right;
		}
	}
	
	static void convertBinaryTreeToDLLPreOrder(Node node, Node [] prev, Node head[]){
		if(node == null)
				return;
		Node temp = null;
		if(prev[0] == null){
			prev[0] = node;
			head[0] = node;
			temp = node.right;
			node.right = null;
		}
		else{
			prev[0].left = node;
			temp = node.right;
			node.right = prev[0]; 
		}
		//temp = node.right;
		prev[0] = node;
		
		convertBinaryTreeToDLLPreOrder(node.left, prev,head);
		convertBinaryTreeToDLLPreOrder(temp, prev,head);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		//root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		//root.right.left = new Node(6);
		//root.right.right = new Node(7);
		Node [] head = new Node[1];
		Node [] prev = new Node[1];
		convertBinaryTreeToDLLPreOrder(root, prev, head);
		printList(head[0]);
		head=head;
	}

}
