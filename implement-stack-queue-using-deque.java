// Problem link - https://www.geeksforgeeks.org/implement-stack-queue-using-deque/

static class Stack {
        deque d = new deque();
        public void push(int element)
        {
            d.insert_last(element);
        }
        public int size() { return d.size(); }
        public void pop() { d.remove_last(); }
    }

    // Class to implement queue using deque
    static class Queue {
        deque d = new deque();

        public void offer(int element)
        {
            d.insert_last(element);
        }
        public void poll() { d.remove_first(); }
        public int size() { return d.size(); }
    }
