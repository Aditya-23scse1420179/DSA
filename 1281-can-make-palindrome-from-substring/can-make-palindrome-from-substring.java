class Solution {
    public List<Boolean>canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] prefix = new int[n+1][26];
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                prefix[i+1][c] = prefix[i][c];
            }
            prefix[i+1][s.charAt(i) - 'a']++;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            int odd = 0;
            for (int c = 0; c < 26; c++) {
                int freq = prefix[r+1][c] - prefix[l][c];
                if (freq % 2 != 0) odd++;
            }
            ans.add(odd/2 <= k);
        }
        return ans;
    }
}
