// Problem link - https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {
    static class Node{
        Node[] links;
        boolean flag;

        Node(){
            links = new Node[26];
            flag = false;
        }
    }

    // Trie class
    private Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node dummy = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(dummy.links[index] == null) dummy.links[index] = new Node();
            dummy = dummy.links[index];
        }
        dummy.flag = true;
    }
    
    public boolean search(String word) {
        return find(0, word.toCharArray(), root);
    }

    private boolean find(int index, char[] arr, Node dummy){
        if(index == arr.length) return dummy.flag;
        char c = arr[index];
        if(c == '.'){
            for(Node child: dummy.links){
                if(child != null && find(index + 1, arr, child)) return true;
            }
            return false;
        } else {
            if(dummy.links[c - 'a'] == null) return false;
            return find(index + 1, arr, dummy.links[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
