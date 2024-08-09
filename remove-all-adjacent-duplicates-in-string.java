// Problem link - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

// TC - O(N)
// SC - O(N)
class Solution {
    class Node{
        char c;
        int count;
        public Node(char c, int count){
            this.c=c;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek().c == c){
                st.peek().count++;
            } else {
                //different character then prev
                st.push(new Node(c, 1));
            }

            if(st.peek().count == k) st.pop(); // remove k duplicates
        }

        // result
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            Node node = st.pop();
            for(int i = 1; i <= node.count; i++){
                sb.append(node.c);
            }
        }

        sb.reverse();
        
        return sb.toString();
    }
}
