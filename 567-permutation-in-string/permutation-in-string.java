class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int k = s1.length();
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);
        for (int i = 0; i <= n - k; i++) {
            String sub = s2.substring(i, i + k);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            String sortedSub = new String(subArr);
            if (sortedSub.equals(sortedS1)) {
                return true; 
            }
        }
        return false;
    }
}
