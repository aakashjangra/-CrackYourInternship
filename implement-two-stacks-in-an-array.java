// Problem link - https://www.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
class twoStacks {
    Integer[] arr; 
    int ptr1; 
    int ptr2;
    int limit;
    twoStacks() {
        limit = 200;
        arr = new Integer[limit];
        ptr1 = 0;
        ptr2 = limit - 1;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        arr[ptr1] = x;
        ptr1++;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        arr[ptr2] = x;
        ptr2--;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(ptr1 == 0) return -1;
        
        ptr1--;
        return arr[ptr1];
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(ptr2 == limit - 1) return -1;
        
        ptr2++;
        return arr[ptr2];
    }
}
