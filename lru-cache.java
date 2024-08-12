// Problem link - https://leetcode.com/problems/lru-cache/

class LRUCache {
    class DLL{
        int key;
        int value;
        DLL pre;
        DLL post;
    }
    private void addNode(DLL node){
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }
    private void removeNode(DLL node){
        DLL pre = node.pre;
        DLL post = node.post;

        pre.post = post;
        post.pre = pre;
    }
    private void moveToHead(DLL node){
        this.removeNode(node);
        this.addNode(node);
    }
    private DLL popTail(){
        DLL res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLL> cache = new HashMap<Integer, DLL>();
    private int count;
    private int capacity;
    private DLL head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLL();
        head.pre = null;

        tail = new DLL();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLL node = cache.get(key);
        if(node == null) return -1;

        this.moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        DLL node = cache.get(key);
        if(node == null){
            DLL newNode = new DLL();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            count++;

            if(count > capacity){
                //pop tail
                DLL tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            } 
        } else {
            //update value
            node.value = value;
            //make it recent
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
