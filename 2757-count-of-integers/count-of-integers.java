class Solution {
    static final int MOD = (int)1e9 + 7;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        Integer[][][] dp2 = new Integer[num2.length()][2][max_sum + 1];
        int right = dfs(num2, 0, 1, 0, min_sum, max_sum, dp2);
        String prev = subtractOne(num1);
        int left = 0;
        if (!prev.equals("-1")) {
            Integer[][][] dp1 = new Integer[prev.length()][2][max_sum + 1];
            left = dfs(prev, 0, 1, 0, min_sum, max_sum, dp1);
        }
        return (right - left + MOD) % MOD;
    }
    private int dfs(String s, int idx, int tight, int sum,int min_sum, int max_sum,Integer[][][] dp) {
        if (sum > max_sum) return 0;
        if (idx == s.length()) {
            return (sum >= min_sum && sum <= max_sum) ? 1 : 0;
        }
        if (dp[idx][tight][sum] != null)
            return dp[idx][tight][sum];
        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int res = 0;
        for (int d = 0; d <= ub; d++) {
            int newTight = (tight == 1 && d == ub) ? 1 : 0;
            res = (res + dfs(s, idx + 1, newTight,sum + d, min_sum, max_sum, dp)) % MOD;
        }
        return dp[idx][tight][sum] = res;
    }
    public static String subtractOne(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == '0') {
            sb.setCharAt(i, '9');
            i--;
        }
        if (i < 0) return "-1";   // means 0 - 1
        sb.setCharAt(i, (char)(sb.charAt(i) - 1));
        if (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
