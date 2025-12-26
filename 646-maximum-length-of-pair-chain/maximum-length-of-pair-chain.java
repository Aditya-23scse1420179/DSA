class Solution {
public int findLongestChain(int[][] pairs) {   
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
    int memo[] = new int[pairs.length];
    Arrays.fill(memo,-1);
    int res = helper(pairs, 0, Integer.MIN_VALUE, memo);
    return res;
}
public int helper(int pairs[][], int index, int prevPairStartingVal, int memo[]){
    if(index >= pairs.length){
        return 0;
    }
    if(memo[index]!=-1)
        return memo[index];
    int include = 0,  skip =0;
    if(pairs[index][0] > prevPairStartingVal){
        include = 1 + helper(pairs,index+1,pairs[index][1],memo);
    }
    skip = helper(pairs, index+1, prevPairStartingVal,memo);
    memo[index] = Math.max(include, skip);
    return memo[index];
}
}