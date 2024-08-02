// Problem link - https://leetcode.com/problems/integer-to-roman/

// TC - O(n) - n is the number of digits in num
// SC - O(1)
class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, Character> roman = new HashMap<>();
        roman.put(1, 'I');
        roman.put(5, 'V');
        roman.put(10, 'X');
        roman.put(50, 'L');
        roman.put(100, 'C');
        roman.put(500, 'D');
        roman.put(1000, 'M');

        StringBuilder sb = new StringBuilder();
        
        int place = 1;
        while(num > 0){
            
            int digit = num % 10;

            if(digit > 0){
                // add it's roman to sb
                // we will add all in reverse order, and will reverse sb at the end
                if(digit <= 3){
                    // digit times that roman
                    while(digit > 0){
                        sb.append(roman.get(1 * place));
                        digit--;
                    }
                } else if(digit == 4){
                    // 1 smaller decimal roman then current decimal 5 
                    sb.append(roman.get(5 * place));
                    sb.append(roman.get(1 * place));
                } else if(digit <= 8){
                    // 5 of current decimal then 1 decimal for each over 5
                    while(digit > 5){
                        sb.append(roman.get(1 * place));
                        digit--;
                    }

                    sb.append(roman.get(5 * place));
                } else if(digit == 9){
                    // 1 smaller decimal roman then one upper decimal 1 
                    sb.append(roman.get(1 * (place * 10)));
                    sb.append(roman.get(1 * place));
                }
            }

            num /= 10;
            place *= 10; 
        }

        sb.reverse();

        return sb.toString();
    }
}
