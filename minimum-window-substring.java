// Problem link - https://leetcode.com/problems/minimum-window-substring/

// TC - O(n)
// SC - O(n)
class Solution {
    public String minWindow(String s, String t) {
        int minWindowLength = s.length() + 1;
        int startIndex = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matches = map.size();

        int i = 0, j = 0, n = s.length();
        while(j < n){
            char c = s.charAt(j);

            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    matches--;
                }
            }

                while(matches == 0){
                    //eligible window
                    int windowSize = j - i + 1;
                    if(windowSize < minWindowLength){
                        minWindowLength = windowSize;
                        startIndex = i;
                    }

                    char charI = s.charAt(i);
                    if(map.containsKey(charI)){
                        map.put(charI, map.get(charI) + 1);
                        if(map.get(charI) > 0){
                            matches++;
                        }
                    }

                    i++;
                }
            j++;
        }

        return (startIndex == -1)? "": s.substring(startIndex, startIndex + minWindowLength);
    }
}
