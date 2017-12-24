
public class ReverseSubLists {
	
	Node head;  // head of list
	  
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
        ReverseSubLists llist = new ReverseSubLists();
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(2);
        llist.push(2);
        //llist.push(2);
        llist.push(1);
         
        System.out.println("Given Linked List");
        llist.printList();
         
        llist.head = llist.reverse(llist.head, 4);
 
        System.out.println("Reversed list");
        llist.printList();
    }

	Node reverse(Node head, int k)
    {
   //add code here
       int counter = 0;
       Node next=null;
       Node prev=null;
       Node cur = head;
       Node prevHead = head;
       Node prevTail=null;
       while(cur!=null){
           if(counter<k){
               next = cur.next;
               cur.next = prev;
               prev = cur;
               cur = next;
               counter++;
           }
           else{
               if(prevTail == null){
            	   head = prev;
               }
               else{
            	   prevTail.next = prev;
            	}
               prevTail = prevHead;
        	   prev = null;
               prevHead = cur;
               counter = 0;
           }
       }
       if(prevTail == null)
    	   head = prev;
       else
    	   prevTail.next = prev;
       return head;
    }
}
