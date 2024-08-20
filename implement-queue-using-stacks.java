// Problem link - https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    Stack<Integer> backup;
    Stack<Integer> queueMimic;
    public MyQueue() {
        backup = new Stack<>();
        queueMimic = new Stack<>();
    }
    
    public void push(int x) {
        backup.push(x);
        manage();
    }
    
    public int pop() {
        manage();
        return queueMimic.pop();
    }
    
    public int peek() {
        manage();
        return queueMimic.peek();
    }

    public boolean empty() {
        return (backup.isEmpty() && queueMimic.isEmpty());
    }

    private void manage() {
        if(queueMimic.isEmpty()){
            //push all elements of backup to queueMimic
            while(!backup.isEmpty()){
                queueMimic.push(backup.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
