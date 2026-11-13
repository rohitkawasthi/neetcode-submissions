class Solution {
    /*
        base case - 1 value
        subproblem - n denominations, amount
        cache[n][amount]
    */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChangeRecursive(coins, amount, coins.length-1);
    }

    private int coinChangeRecursive(int[] coins, int amount, int lastCoinIndex) {
        if(amount%coins[lastCoinIndex]==0) {
            return amount/coins[lastCoinIndex];
        }
        if(lastCoinIndex==0) {
            return -1;
        }
        int coinMinCount = -1;
        for(int i=amount/coins[lastCoinIndex]; i>=0; i--) {
            int remainingAmount = amount - i*coins[lastCoinIndex];
            int subCount = coinChangeRecursive(coins, remainingAmount, lastCoinIndex-1);
            if(subCount==-1) {
                continue;
            }
            coinMinCount = coinMinCount!=-1 ? Math.min(coinMinCount, i+subCount) : i+subCount;
        }
        return coinMinCount;
    }
}
