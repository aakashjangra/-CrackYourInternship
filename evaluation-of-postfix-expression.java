// Problem link - https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1

// TC - O(n)
// SC - O(n)
class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < S.length(); i++){
            // when operator comes, remove top 2 values, evaluate and push result to stack
            char c = S.charAt(i);
            
            if('0' <= c && c <= '9'){
                st.push(Integer.parseInt(c+""));
            } else {
                //operation
                int a = st.pop();
                int b = st.pop();
                
                switch(c) {
                    case '-': 
                        {
                            st.push(b - a);
                            break;
                        }
                    case '/': 
                        {
                            st.push(b / a);
                            break;
                        }
                    case '+': 
                        {
                            st.push(a + b);
                            break;
                        }
                    case '*': 
                        {
                            st.push(a * b);
                            break;
                        }
                }
            }
        }
        
        return st.peek();
    }
}
