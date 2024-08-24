// Problem link - https://www.geeksforgeeks.org/problems/word-break-trie--141631/1

class Solution
{
    static class Trie {
    static class Node{
        Node[] links = new Node[26];
        boolean flag = false;

        public Node(){}

        boolean containsKey(char c){
            return links[c - 'a'] != null;
        }

        Node get(char c){
            return links[c - 'a'];
        }

        void put(char c, Node node){
            links[c - 'a'] = node;
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }

    // Trie class
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new Node());
            }

            node = node.get(c);
        }

        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }

            node = node.get(c);
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }

            node = node.get(c);
        }

        return true; // prefix is found
    }
}
    public static int wordBreak(String A, ArrayList<String> B )
    {
        Trie trie = new Trie();
        for(String word: B) trie.insert(word);
        
        boolean res = solve(A, trie);
        
        return (res? 1: 0);
    }
    
    private static boolean solve(String s, Trie trie){
        if(s.length() == 0) return true;
        
        for(int i = 1; i <= s.length(); i++){
            if(trie.search(s.substring(0, i)) && solve(s.substring(i), trie)) return true;
        }
        
        return false;
    }
}
