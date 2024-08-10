// Problem link - https://www.geeksforgeeks.org/problems/search-pattern-rabin-karp-algorithm--141631/1

// n => txt length, m => pat length
// TC - O(n*m)
// SC - O(1)
class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int base = 256;
        int mod = 101; //prime number
        int p = 0; // hash value of pattern
        int t = 0; // hash value of text
        int h = 1;
 
        // h = "pow(base, M-1)%mod"
        for (i = 0; i < M - 1; i++)
            h = (h * base) % mod;
 
        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (base * p + pat.charAt(i)) % mod;
            t = (base * t + txt.charAt(i)) % mod;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (i = 0; i <= N - M; i++) {
            //if hash values match, check individual characters
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
 
                if (j == M) //if above loop completed. All chars are same
                    ans.add(i + 1);
            }
 
            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (base * (t - txt.charAt(i) * h)
                     + txt.charAt(i + M))
                    % mod;
 
                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + mod);
            }
        }
        
        return ans;
    }
}
