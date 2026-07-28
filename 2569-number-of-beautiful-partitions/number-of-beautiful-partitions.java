class Solution {
	public final static int MOD = 1_000_000_007;
	public int beautifulPartitions(String s, int k, int minLength) {
		int n = s.length();
		if (!isPrime(s.charAt(0)) || isPrime(s.charAt(n - 1))) return 0;
		int[][]dp= new int[k][n];
		Arrays.fill(dp[0], 1);
		for (int i =1;i<k;i++){
			for (int j =1;j< n;j++){
				if(j-0>=minLength&&n-j>=minLength&&!isPrime(s.charAt(j-1))&&isPrime(s.charAt(j))){
					dp[i][j]=(dp[i][j-1]+dp[i-1][j-minLength])%MOD;//nocut+cut
				}else{
					dp[i][j]=dp[i][j - 1];    // no cut here.
				}
			}
		}
		return dp[k-1][n-1];
	}
	public  boolean isPrime(char ch) {
		return ch == '2' || ch == '3' || ch == '5' || ch == '7';
	}
}