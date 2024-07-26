// Problem link - https://leetcode.com/problems/combination-sum-ii/description/

// TC - O(2^N)
// SC - O(N)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            if (counter.containsKey(candidate)) counter.put(
                candidate,
                counter.get(candidate) + 1
            );
            else counter.put(candidate, 1);
        }

        List<int[]> counterList = new ArrayList<>();
        counter.forEach((key, value) -> {
            counterList.add(new int[] { key, value });
        });

        helper(combination, target, 0, counterList, combinations);
        return combinations;
    }

    private void helper(
        LinkedList<Integer> combination,
        int target,
        int pos,
        List<int[]> counter,
        List<List<Integer>> combinations
    ) {
        if (target <= 0) {
            if (target == 0) {
                combinations.add(new ArrayList<Integer>(combination));
            }
            return;
        }

        for (int nextCurr = pos; nextCurr < counter.size(); ++nextCurr) {
            int[] entry = counter.get(nextCurr);
            Integer candidate = entry[0], freq = entry[1];

            if (freq <= 0) continue;

            // add a new element to the current combination
            combination.addLast(candidate);
            counter.set(nextCurr, new int[] { candidate, freq - 1 });

            // continue the exploration with the updated combination
            helper(combination, target - candidate, nextCurr, counter, combinations);

            // helper the changes, so that we can try another candidate
            counter.set(nextCurr, new int[] { candidate, freq });
            combination.removeLast();
        }
    }
}
