// Problem link - https://leetcode.com/problems/text-justification/

// TC - O(N)
// SC - O(N)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordsTaken = 0;
        List<String> collection = new ArrayList<>();
        int n = words.length;
        List<String> ans = new ArrayList<>();
        collection.add(words[0]);
        wordsTaken = words[0].length();

        for(int i = 1; i < n; i++){
            String word = words[i];
            //add if possible
            if(wordsTaken + 1 + word.length() <= maxWidth){
                collection.add(word);
                wordsTaken += 1 + word.length();
            } else {
            //assemble String and add to ans
                int places = collection.size() - 1;
                int characters = (wordsTaken - places);
                int whitespaces = maxWidth - characters;

                int spaceBetween = (places == 0? 0: whitespaces/places);
                int extraSpaces = (places == 0)? 0: whitespaces % places;
                String line = assemble(collection, spaceBetween, extraSpaces, maxWidth);

                ans.add(line);
                collection = new ArrayList<>();
                collection.add(word);
                wordsTaken = word.length();
            }
        }

        if(collection.size() > 0){
            String remLine = assemble(collection, 1, 0, maxWidth);
            ans.add(remLine);
        }

        return ans;
    }

    private String assemble(List<String> list, int spaceBetween, int addExtra, int maxWidth){
        StringBuilder sb = new StringBuilder();

        sb.append(list.get(0));

        for(int i = 1; i < list.size(); i++){
            if(addExtra > 0){
                //extra space if firstExtraSpace is true
                sb.append(" ");
                addExtra--; 
            }

            //add spaceBetween no. of spaces
            for(int j = 0; j < spaceBetween; j++) sb.append(" ");
            // then add the word
            sb.append(list.get(i));
        }

        for(int i = sb.length(); i < maxWidth; i++){
            sb.append(" ");
        }

        return sb.toString();
    }
}
