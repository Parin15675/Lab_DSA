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
    

    public static void main(String[] args) {
        int[] testArray1 = {1, 5, 11, 5};
        int[] testArray2 = {1, 5, 3};
        int[] testArray3 = {2, 4, 6, 10};

        System.out.println("Can partition {1, 5, 11, 5}: " + canPartition_Recurse(testArray1)); // Expected: true
        System.out.println("Can partition {1, 5, 3}: " + canPartition_Recurse(testArray2));     // Expected: false
        System.out.println("Can partition {2, 4, 6, 10}: " + canPartition_Recurse(testArray3)); // Expected: true

        System.err.println(canPartition_Memoiz(testArray1));
        System.err.println(canPartition_Memoiz(testArray2));
        System.err.println(canPartition_Memoiz(testArray3));
        
        System.err.println(canPartition_DP(testArray1));
        System.err.println(canPartition_DP(testArray2));
        System.err.println(canPartition_DP(testArray3));
    }
}
