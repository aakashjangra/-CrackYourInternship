// Problem link - https://leetcode.com/problems/reverse-words-in-a-string/

// TC - O(n)
// SC - O(n)
class Solution {
    public String reverseWords(String s) {
        ArrayList<String> words = new ArrayList<>();

        StringBuilder currentWord = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(currentWord.length() > 0){
                    words.add(currentWord.toString());
                }
                currentWord = new StringBuilder();
            } else {
                currentWord.append(s.charAt(i));
            }
        }

        if(currentWord.length() > 0){
            words.add(currentWord.toString());
        }

        Collections.reverse(words);

        return String.join(" ", words);
    }
}
