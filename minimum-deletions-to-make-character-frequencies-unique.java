// Problem link - https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

// TC - O(N)
// SC - O(N)
class Solution {
    public int minDeletions(String s) {
        //will traverse in frequencies and reduce freq of char if it's not unique
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int deletions = 0;
        Set<Integer> set = new HashSet<>();
        for(int freq: map.values()){
            if(set.contains(freq)){
                //make deletions
                while(freq > 0){
                    freq--;

                    deletions++;

                    if(!set.contains(freq)){
                        set.add(freq);
                        break;
                    }
                }
            } else {
                set.add(freq);
            }
        }

        return deletions;
    }
}
