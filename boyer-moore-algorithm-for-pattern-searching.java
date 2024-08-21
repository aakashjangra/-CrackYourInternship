// Problem link - https://www.geeksforgeeks.org/boyer-moore-algorithm-for-pattern-searching/

// TC - (n + m)
// SC - (n + m)
class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        int m = pattern.length(), n = text.length();
        ArrayList<Integer> foundAt = new ArrayList<>();
        
        int[] badChar = new int[256];
        
        char[] pat = pattern.toCharArray();
        char[] txt = text.toCharArray();
        
        badCharHeuristic(pat, m, badChar);
        
        int s = 0; //shift of pattern
        
        while(s <= (n - m)){
            int j = m - 1;
            
            while(j >= 0 && pat[j] == txt[s + j])
            {
                j--;
            }
            
            if(j < 0){
                foundAt.add(s + 1);
                
                s += 
                (s + m < n) 
                ? m - badChar[txt[s + m]]
                : 1;
            } else {
                s += Math.max(1, j - badChar[txt[s + j]]);
            }
        }
        
        return foundAt;
    }
    
    void badCharHeuristic(char[] str, int size, int badChar[]){
        Arrays.fill(badChar, -1);
        
        for(int i = 0; i < size; i++){
            badChar[(int)str[i]] = i;
        }
    }
}
