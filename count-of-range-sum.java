// Problem link - https://leetcode.com/problems/count-of-range-sum/description/

// TC - O(nlogn)
// SC - O(n)
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSums = new long[nums.length + 1];
        
        for(int index = 0; index < nums.length; index++){
            if(index == 0){
                prefixSums[index + 1] = nums[index];
            } else {
                prefixSums[index + 1] = prefixSums[index] + nums[index];
            }
        }

        //assigning ranks 
        long[] sortedPrefixSums = prefixSums.clone();
        Arrays.sort(sortedPrefixSums);

        int rank = 0;
        TreeMap<Long, Integer> ranks = new TreeMap<>();
        for(int index = 0; index < sortedPrefixSums.length; index++){
            if(!ranks.containsKey(sortedPrefixSums[index])){
                ranks.put(sortedPrefixSums[index], rank++);
            }
        }

        int count = 0;
        SegmentTree tree = new SegmentTree(0, rank);
        for(int index = prefixSums.length - 1; index >= 0; index--){
            Long lowerBound = ranks.floorKey(prefixSums[index] + lower - 1);
            int minRank = -1;
            if(lowerBound != null){
                minRank = ranks.get(lowerBound) + 1;
            }

            Long upperBound = ranks.floorKey(prefixSums[index] + upper);
            int maxRank = -1;
            if(upperBound != null){
                maxRank = ranks.get(upperBound);
            }

            count += tree.query(minRank, maxRank);

            tree.update(ranks.get(prefixSums[index]));
        }

        return count;
    }

    public class SegmentTree {
	private final int min;
	private final int max;
	private final int[] tree;
	
	/**
	 * Assume both min and max are non-negative here.
	 **/
	public SegmentTree(int min, int max) {
		this.min = min;
		this.max = max;
		this.tree = new int[(max - min) * 4];
	}
	
	public int query(int min, int max) {
		return query(0, this.min, this.max, min, max);
	}
	
	private int query(int treeIndex, int lo, int hi, int min, int max) {
		if (min > hi || max < lo) {
			return 0;
		} else if (min <= lo && max >= hi) {
			return tree[treeIndex];
		}
		
		int mid = lo + (hi - lo) / 2;
		if (max <= mid) {
			return query(treeIndex * 2 + 1, lo, mid, min, max);
		} else if (min > mid) {
			return query(treeIndex * 2 + 2, mid + 1, hi, min, max);
		}
		
		int left = query(treeIndex * 2 + 1, lo, mid, min, mid);
		int right = query(treeIndex * 2 + 2, mid + 1, hi, mid + 1, max);
		
		return left + right;
	}
	
	public void update(int num) {
		update(0, this.min, this.max, num);
	}
	
	private void update(int treeIndex, int lo, int hi, int num) {
		if (lo == hi) {
			tree[treeIndex] += 1;
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		if (num <= mid) {
			update(treeIndex * 2 + 1, lo, mid, num);
		} else {
			update(treeIndex * 2 + 2, mid + 1, hi, num);
		}
		
		tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
	}
}
}
