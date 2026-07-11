class Solution {
    public List<Integer> findCoins(int[] numWays) {
    int n = numWays.length;
    long[] myWays = new long[n + 1];
    myWays[0] = 1;
    List<Integer> res = new ArrayList<>();
    for (int i =1;i<=n;i++){
        if (myWays[i]==numWays[i-1]) continue;
        if (numWays[i-1]-myWays[i]==1){
            res.add(i);
            for (int j =i;j <=n;j++){
                myWays[j]+= myWays[j-i];
            }
        } else {
            return Collections.emptyList();
        }
    }
    return res;
}
}