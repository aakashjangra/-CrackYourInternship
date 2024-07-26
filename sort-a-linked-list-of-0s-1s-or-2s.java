// Problem link - https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/

// TC - O(n)
// SC - O(1)
import java.util.*;

class LinkedList
{
    Node head;  // head of list
  
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
 
    void sortList()
    {
       Map<Integer, List<Node>> map = new HashMap<>();
       map.put(0, new ArrayList<>());
       map.put(1, new ArrayList<>());
       map.put(2, new ArrayList<>());

       Node temp = head;
       
       while(temp != null){
           map.get(temp.data).add(temp);
           
           temp = temp.next;
       }
       
       Node dummy = new Node(0);
       Node dummyPtr = dummy;
       
       for(int val = 0; val <= 2; val++){
           for(Node cur: map.get(val)){
               dummyPtr.next = cur;
               dummyPtr = dummyPtr.next;
               
               dummyPtr.next = null;
           }
       }
       
       head = dummy.next;
    }                       
 
                    
    /* Utility functions */
 
    /* Inserts a new Node at front of the list. */
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
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
         
        /* Constructed Linked List is 1->2->3->4->5->6->7->
           8->8->9->null */
        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);
         
        System.out.println("Linked List before sorting");
        llist.printList();
         
        llist.sortList();
 
        System.out.println("Linked List after sorting");
        llist.printList();
    }
} 
