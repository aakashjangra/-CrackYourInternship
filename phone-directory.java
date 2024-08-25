// Problem link - https://www.geeksforgeeks.org/problems/phone-directory4628/1

class Solution{
    static class Node{
        Node links[] = new Node[26];
        boolean flag = false;
        ArrayList<String> data;
        
        public Node(){
            data = new ArrayList<>();
        }
    }
    
    private static Node root = null;
    private static ArrayList<ArrayList<String>> ans;
    
    private static void insert(String key){
        Node node = root;
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(node.links[idx] == null){
                node.links[idx] = new Node();
            }
            node.links[idx].data.add(key);
            node = node.links[idx];
        }
        node.flag = true;
    }
    
    private static void displayContact(String str){
        Node node = root;
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            
            if(node.links[idx] != null && i == str.length() - 1){
                ArrayList<String> list = node.links[idx].data;
                Collections.sort(list);
                ans.add(list);
            }
            
            if(node.links[idx] == null){
                ArrayList<String> temp = new ArrayList<>();
                temp.add("0");
                ans.add(temp);
                
                return;
            }
            
            node = node.links[idx];
        }
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        root = new Node();
        ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for(String str: contact){
            set.add(str);
        }
        
        // we want to show unique results for each query
        for(String str: set){
            insert(str);
        }
        
        for(int i = 1; i <= s.length(); i++){
            displayContact(s.substring(0, i));
        };
        
        return ans;
    }
}
