
//Java program to construct BST from given preorder traversal

//A binary tree node
 
/*            50
         25          75
     10     30    60     80
     
 50 25 10 30 75 60 80
 
*/  



class constructBSTFromInorder {
	
	 static class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

 static Node constructTree(int [] pre, int[] preInd, int low, int high){
     if(preInd[0]>=pre.length)
         return null;
     
     Node node = null;
     
     if(pre[preInd[0]]>=low && pre[preInd[0]]<high){
         
         node = new Node(pre[preInd[0]]);
         preInd[0]++;
         
         node.left = constructTree(pre, preInd, low, node.data );
         
         node.right = constructTree(pre, preInd, node.data, high);
     }
     
     return node;
 }	

 void printInorder(Node root){
     if(root == null)
         return ;
         
     printInorder(root.left);
     System.out.print(root.data + " ");
     printInorder(root.right);
 }


	// Driver program to test above functions
	public static void main(String[] args) {
		constructBSTFromInorder tree = new constructBSTFromInorder();
		int pre[] = new int[]{50,10,10,30,75,60,80};
		int size = pre.length;
		int [] preInd = new int[1];
		preInd[0] = 0;
		Node root = constructTree(pre, preInd, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
	}
}

