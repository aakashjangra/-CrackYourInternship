// Problem link - https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

// TC - O(m * log n)
// SC - O(n)
class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        Node dummy = new Node(0);
        Node ans = dummy;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.data, b.data));

        while(root != null){
            pq.offer(root);
            root = root.next;
        }
        
        while(!pq.isEmpty()){
            Node smallest = pq.poll();
            
            dummy.bottom = smallest;
            smallest.next = null;
            
            if(smallest.bottom != null){
                pq.offer(smallest.bottom);
            }
            
            dummy = dummy.bottom;
        }
        
        return ans.bottom;
    }
}
