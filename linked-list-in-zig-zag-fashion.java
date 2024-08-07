// Problem link - https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/

// TC - O(N)
// SC - O(1)
static void zigZagList(Node head) 
	{ 
      boolean flag = true; // flag - true means '<' relation is expected, false means '>' relation is expected
      
      while(head != null && head.next != null){
      		if((flag && head.data > head.next.data) || (!flag && head.data < head.next.data)){
              	// swap values
                int temp = head.data;
                head.data = head.next.data;
                head.next.data = temp;
            }
        
        	head = head.next;
        	flag = !flag;
      }
	} 
