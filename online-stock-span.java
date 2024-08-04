// Problem link - https://leetcode.com/problems/online-stock-span/

// TC - O(n)
// SC - O(n)
class StockSpanner {
    int index;
    Stack<int[]> st;
    public StockSpanner() {
        this.st = new Stack<>();
        this.index = 1;
    }
    
    public int next(int price) {
        int span = 1;
        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }

        if(!st.isEmpty()){
            span = index - st.peek()[1];
        } else {
            span = index;
        }

        st.push(new int[]{price, index});
        index++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
