// Problem link - https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

// TC - O(n log k)
// SC - O(n + k)
class Solution {
    private class RatioAndQuality {
        double ratio;
        int quality;

        RatioAndQuality(double r, int q){
            this.ratio = r;
            this.quality = q;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;

        RatioAndQuality[] wtqr = new RatioAndQuality[n];

        long currentTotalQuality = 0l;
        double totalCost = Double.MAX_VALUE;

        for(int i = 0; i < n; i++){
            wtqr[i] = new RatioAndQuality((double)wage[i]/quality[i], quality[i]);
        }

        // ascending order acc. to ratio
        Arrays.sort(wtqr, (a,b) -> Double.compare(a.ratio, b.ratio));

        PriorityQueue<RatioAndQuality> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.quality, a.quality)
        );

        for(int i = 0; i < n; i++){
            RatioAndQuality cur = wtqr[i];

            maxHeap.offer(cur);

            double r = cur.ratio;
            int qual = cur.quality;

            currentTotalQuality += qual;

            if(maxHeap.size() > k){
                //remove last and update vars
                RatioAndQuality lastNode = maxHeap.poll();
                currentTotalQuality -= lastNode.quality;
            }

            if(maxHeap.size() == k){
                double curCost = wtqr[i].ratio * currentTotalQuality;

                if(curCost < totalCost){
                    totalCost = curCost;
                }
            }
        }

        return totalCost;
    }
}
