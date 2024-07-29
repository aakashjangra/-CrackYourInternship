// Problem link - https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1

// TC - O(n + m)
// SC - O(1)
class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // find bigger LL
        Node ptr1 = head1;
        Node ptr2 = head2;
        
        //remove leading zeros
        while(ptr1 != null && ptr1.data == 0 && ptr1.next != null){
            ptr1 = ptr1.next;
        }
        
        while(ptr2 != null && ptr2.data == 0 && ptr2.next != null){
            ptr2 = ptr2.next;
        }
        
        boolean firstIsBigger = true;
        
        while(ptr1 != null && ptr2 != null){
            
            if(ptr1.data > ptr2.data){
                break;
            } else if(ptr2.data > ptr1.data){
                firstIsBigger = false;
                break;
            }
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        while(ptr1 != null && ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        if(ptr1 == null && ptr2 != null){
            firstIsBigger = false;
        } else if(ptr2 == null && ptr1 != null){
            firstIsBigger = true;
        }
        
        // reverse both LL 
        Node reversed1 = reverseLL(head1);
        Node reversed2 = reverseLL(head2);
        
        Node biggerLL = reversed2;
        Node smallerLL = reversed1;
        
        if(firstIsBigger){
            biggerLL = reversed1;
            smallerLL = reversed2;
        }
        
        // subtract 
        int carry = 0;
        
        ptr1 = biggerLL;
        ptr2 = smallerLL;
        
        while(ptr1 != null && ptr2 != null){
            int res = 0;
            
            if(ptr1.data < ptr2.data + carry){
                //we have to take carry from ahead
                res = ((10 + ptr1.data) - ptr2.data - carry);   // *10 for carry 
                carry = 1;
            } else {
                res = (ptr1.data - carry) - ptr2.data;
                carry = 0;
            }
            
            ptr1.data = res;
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            
        }
        
        while(ptr1 != null){
            if(carry == 1){
                if(ptr1.data == 0){
                    // carry forward
                    ptr1.data = 9;
                    carry = 1;
                } else {
                    ptr1.data = ptr1.data - carry;
                    carry = 0;
                }
            } 
            
            // if carry == 0, dataues remains the same
            ptr1 = ptr1.next;
        }
        
        // reverseAns
        Node ans = reverseLL(biggerLL);
        
        //remove leading zeros
        while(ans != null && ans.data == 0 && ans.next != null){
            ans = ans.next;
        }
        
        return ans;
    }
    
    private Node reverseLL(Node head){
        if(head == null || head.next == null) return head;
        
        Node p = head, c = head.next, n = head.next.next;
        
        while(n != null){
            c.next = p;
            
            p = c;
            c = n;
            n = n.next;
        }
        
        c.next = p;
        head.next = null;
        
        return c;
    }
}
