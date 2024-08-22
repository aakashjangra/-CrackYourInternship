// Problem link - https://leetcode.com/problems/maximum-number-of-visible-points/

// TC - O(N log N)
// SC - O(2N)
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> positions = new ArrayList<>();
        int count = 0;
        for(List<Integer> point: points){
            int x = point.get(0) - location.get(0);
            int y = point.get(1) - location.get(1);
            if(x == 0 && y == 0){
                count++;
                continue;
            }

            double v = (Math.atan2(y, x) * 180 / Math.PI);
            System.out.println(v);
            positions.add(v);
        }

        Collections.sort(positions);

        List<Double> list = new ArrayList<>(positions);

        for(int i = 0; i < positions.size(); i++){
            list.add(360 + positions.get(i));
        }

        int low = 0, high = 0;
        int max = 0;

        //sliding window
        while(high < list.size()){
            double lowAngle = list.get(low);
            double highAngle = list.get(high);
            if(highAngle - lowAngle <= angle){
                max = Math.max(high - low + 1, max);
                high++;
            } else {
                low++;
            }
        }

        return max + count;
    }
}
