class Solution {
   

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        int[]dp = new int[amount+1];

        for(int i = 1 ; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int c : coins){
                if(c<=i && dp[i-c] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-c]);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}