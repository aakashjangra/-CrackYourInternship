// Problem link - https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/

// TC - O(n)
// SC - O(n)
class Solution
{
  static void printDuplicates(String str)
  {
    Map<Character, Integer> map = new HashMap<>();
    
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (Character key : map.keySet()) { 
      if (map.get(key) > 1)
        System.out.println(key + ", count = " + map.get(key));
    }
  }

  public static void main(String args[])
  {
    String str = "print duplicates";
    printDuplicates(str);
  }
}
