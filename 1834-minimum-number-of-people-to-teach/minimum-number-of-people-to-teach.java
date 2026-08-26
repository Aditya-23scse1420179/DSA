class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        boolean[][] knows = new boolean[languages.length + 1][n + 1];
        for (int i = 0; i < languages.length; i++) {
            for (int l : languages[i]) knows[i + 1][l] = true;
        }
        Set<Integer> teach = new HashSet<>();
        for (int[] f : friendships) {
            boolean canTalk = false;
            for (int l = 1; l <= n; l++) {
                if (knows[f[0]][l] && knows[f[1]][l]) canTalk = true;
            }
            if (!canTalk) {
                teach.add(f[0]);
                teach.add(f[1]);
            }
        }
        int maxKnown = 0;
        for (int l = 1; l <= n; l++) {
            int count = 0;
            for (int u : teach) {
                if (knows[u][l]) count++;
            }
            maxKnown = Math.max(maxKnown, count);
        }
        return teach.size() - maxKnown;
    }
}