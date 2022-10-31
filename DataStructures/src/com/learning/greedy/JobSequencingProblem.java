package com.learning.greedy;

import java.util.Arrays;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "\nJob{" +
                "id=" + id +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}

public class JobSequencingProblem {

    public static void main(String[] args) {

        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        JobSequencingProblem obj = new JobSequencingProblem();
        obj.jobScheduling(arr, 4);

        int[] res = obj.jobScheduling(arr, 4);
        System.out.println(res[0] + " " + res[1]);

    }

    int[] jobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        System.out.println(Arrays.asList(arr));

        int maximumDeadline = 0;
        for (Job each : arr) {
            if (each.deadline > maximumDeadline) {
                maximumDeadline = each.deadline;
            }
        }
        System.out.println("maximumDeadline :- " + maximumDeadline);

        //+1 because we start from 1, and populate all -1s
        int result[] = new int[maximumDeadline + 1];
        for (int i = 1; i < maximumDeadline; i++) {
            result[i] = -1;
        }

        int countJobs = 0, jobProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                //Start from deadline and find a freeslot
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }

}
