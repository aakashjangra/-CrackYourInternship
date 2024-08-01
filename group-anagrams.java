// Problem link - https://leetcode.com/problems/group-anagrams/

// TC - O(n * l * log(l)) - n is length of strs[] and l is the length of longest string in strs[] array
// SC - O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        HashMap<String, List<String>> mapCodeToAnagram = new HashMap<>();

        for(String str: strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);

            String code = new String(charArr);

            List<String> thisCodeAnagrams = mapCodeToAnagram.getOrDefault(code, new ArrayList<>());

            if(!mapCodeToAnagram.containsKey(code)){
                mapCodeToAnagram.put(code, thisCodeAnagrams);
            }

            thisCodeAnagrams.add(str);
        }

        for(List<String> distinctAnagramGroup: mapCodeToAnagram.values()){
            groupedAnagrams.add(distinctAnagramGroup);
        }

        return groupedAnagrams;
    }
}
