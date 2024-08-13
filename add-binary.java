// Problem link - https://leetcode.com/problems/add-binary/

// n is the length of longest string
// TC - O(n)
// SC - O(n)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();

        int carry = 0;

        int lenA = a.length(), lenB = b.length();
        int n = Math.max(lenA, lenB);

        for(int i = 0; i < n; i++){
            int indexA = lenA - i - 1;
            int indexB = lenB - i - 1;

            int digit1 = (indexA >= 0)? a.charAt(indexA) - '0': 0;
            int digit2 = (indexB >= 0)? b.charAt(indexB) - '0': 0;

            int current = carry + digit1 + digit2;
            if(current >= 2){
                carry = 1;
            }

            int num = 0;
            if(current == 1 || current == 3){
                num = 1;
            }

            if(current > 1) carry = 1;
            else carry = 0;

            sum.append((char)(num + '0'));
        }

        if(carry == 1){
            sum.append("1");
        }

        sum.reverse();

        return sum.toString();
    }
}
