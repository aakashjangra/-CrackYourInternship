// Problem link - https://leetcode.com/problems/word-ladder/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList); //set of words in wordList, to access them in ~O(n) time
        if(!words.contains(endWord)) return 0; //not possible if endWord is not in wordList

        int steps = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.add(beginWord);
        set.add(beginWord);

        while(q.size() > 0){
            int n = q.size();
            while(n-- > 0){
                String word = q.poll();
                int len = word.length();
                
                for(int i = 0; i<len; i++){
                    String pre = word.substring(0, i);
                    String post = word.substring(i+1, len);
                    for(char c = 'a'; c <= 'z'; c++){
                        String next = pre + c + post;
                        if(words.contains(next) && !set.contains(next)){
                            if(next.equals(endWord)){
                                return steps + 1;
                            } else {
                                q.add(next);
                                set.add(next);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return 0; //not possible
    }
}
