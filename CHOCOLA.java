// Problem link - https://www.spoj.com/problems/CHOCOLA/

// TC - O((n log n) + (m log m))
// SC - O(1)
import java.util.*;
import java.lang.*;
import java.util.Arrays;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0){
			int m = sc.nextInt() - 1;
			int n = sc.nextInt() - 1;
			
			int[] arr1 = new int[m];
			int[] arr2 = new int[n];
			
			for(int i = 0; i < m; i++){
				arr1[i] = sc.nextInt();
			}
			for(int i = 0; i < n; i++){
				arr2[i] = sc.nextInt();
			}
			
			long ans = minCost(arr1, arr2, m, n);
			System.out.println(ans);
		}
	}
	private static int minCost(int[] x, int[] y, int m, int n){
		Arrays.sort(x);
		Arrays.sort(y);
		
		int hCount = 1; //horizontal count
		int vCount = 1; // vertical count
		
		int ans = 0;
		
		int i = m - 1, j = n - 1;
		
		while(i >= 0 && j >= 0){
		    if(x[i] > y[j]){
		        ans += x[i] * vCount;
		        hCount++;
		        i--;
		    } else {
		        ans += y[j] * hCount;
		        vCount++;
		        j--;
		    }
		}
		
		while(i >= 0){
		    ans += x[i] * vCount;
		    i--;
		}
		
		while(j >= 0){
		    ans += y[j] * hCount;
		    j--;
		}
	
		return ans;
	}
}
