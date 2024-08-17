package solutions.pack;

import java.util.Arrays;

public class EqualSubsets {

    public static boolean canPartition_Recurse(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        if (totalSum % 2 != 0) return false;
        return canPartitionHelper(arr, 0, totalSum / 2);
    }

    private static boolean canPartitionHelper(int[] arr, int index, int sum) {
        if (sum == 0) return true;
        if (index == arr.length || sum < 0) return false;
        return canPartitionHelper(arr, index + 1, sum - arr[index]) || canPartitionHelper(arr, index + 1, sum);
    }

    public static boolean canPartition_Memoiz(int [] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) {
            return false;
        }
        Boolean [][] memo = new Boolean[arr.length][sum/2 + 1];
        return canPartition_Memoiz(arr, sum/2, 0, memo);
    }
    public static boolean canPartition_Memoiz(int [] arr, int sum, int index, Boolean [][] memo) {
        if (sum == 0) {
            return true;
        }
        if (index == arr.length || sum < 0) {
            return false;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum];
        }
        memo[index][sum] = canPartition_Memoiz(arr, sum - arr[index], index + 1, memo) || canPartition_Memoiz(arr, sum, index + 1, memo);
        return memo[index][sum];
    }
    public static boolean canPartition_DP(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
    
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
