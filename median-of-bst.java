// Problem link - https://www.geeksforgeeks.org/problems/median-of-bst/1

// TC - O(n)
// SC - O(n)
class Tree
{
    public static float findMedian(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int n = list.size();
        
        if(n % 2 == 0){
            //even - 2 middle elements, return their avg.
            return ((float)list.get(n/2) + (float)list.get((n/2) - 1))/2;
        }
        
        return list.get(n/2);
    }
    
    private static void inorder(Node root, ArrayList<Integer> list){
        if(root == null) return;
        
        inorder(root.left, list);
        
        list.add(root.data);
        
        inorder(root.right, list);
    }
}
