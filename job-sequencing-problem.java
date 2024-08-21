// Problem link - https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

// TC - O(N log N)
// SC - O(M) - M is the maximum deadline
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        //sort by profits in descending order
        Arrays.sort(arr, (a,b)-> b.profit - a.profit);
        
        int maxDeadline = 1;
        for(Job job: arr){
            if(maxDeadline < job.deadline){
                maxDeadline = job.deadline;
            }
        }
        
        int[] deadlines = new int[maxDeadline + 1];
        Arrays.fill(deadlines, -1);
        int jobs = 0, totalProfit = 0;
        
        for(Job job: arr){
            for(int j = job.deadline; j >= 1; j--){
                if(deadlines[j] == -1){
                    deadlines[j] = job.profit;
                    jobs++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        return new int[]{jobs, totalProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
