// Problem link - https://www.geeksforgeeks.org/problems/print-anagrams-together/1

// TC - O(m * (n log n)) - m is length of string_list and n is length of string (element of string_list)
// SC - O(n)
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String str: string_list){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            
            String sortedString = new String(charArr);
            
            if(map.containsKey(sortedString)){
                map.get(sortedString).add(str);
            } else {
                map.put(sortedString, new ArrayList<>());
                map.get(sortedString).add(str);
            }
        }
        
        List<List<String>> anagramsTogether = new ArrayList<>();
        
        for(List<String> list: map.values()){
            anagramsTogether.add(list);
        }
        
        return anagramsTogether;
    }
}
