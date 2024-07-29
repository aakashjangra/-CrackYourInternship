// Problem link - https://www.spoj.com/problems/AGGRCOW/

// TC - O(n logn)
// SC - O(1)
import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		//number of test cases
		while(t-- > 0){
			int n = sc.nextInt();
			int c = sc.nextInt();
			List<Integer> storeLocations = new ArrayList<>();
			for(int store = 1; store <= n; store++){
				storeLocations.add(sc.nextInt());
			}
			
			int maxMinDistance = findLargestMinDistance(n, c, storeLocations);
			System.out.println(maxMinDistance);
		}
	}
	
	public static int findLargestMinDistance(int n, int c, List<Integer> storeLocations){
		int ans = 0; 
		
		// sort storeLocations ASC
		Collections.sort(storeLocations);
		
		//binary search
		int s = 1, e = (storeLocations.get(n - 1) - storeLocations.get(0));
		
		while(s <= e){
			int mid = s + (e - s)/2;
			
			if(coversAllStores(n, mid, c, storeLocations)){
				s = mid + 1;
				ans = mid;
			} else {
				e = mid - 1;
			}
		}
		
		return ans;
	}
	
	public static boolean coversAllStores(int n, int minDist, int c, List<Integer> storeLocations){
		
		//placing a cow at 1st stall
		int lastCowPosition = storeLocations.get(0);
		c--;
		
		// starting from 2nd stall
		for(int i = 1; i < n; i++){
			int dist = storeLocations.get(i) - lastCowPosition;
			
			if(dist >= minDist){
				c--; //place a cow at this store
				lastCowPosition = storeLocations.get(i);
			}
		}
		
		return (c <= 0); // true if all cows are placed
	}
}
