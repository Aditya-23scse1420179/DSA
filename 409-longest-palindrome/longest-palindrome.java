class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];  
        for (char c: s.toCharArray()) {
            freq[c]++;
        }
        int length =0;
        boolean hasOdd = false;
        for (int cnt: freq) {
            if (cnt%2== 0) {
                length+=cnt;
            } else {
                length+= cnt-1;
                hasOdd =true;
            }
        }
        if (hasOdd){
            length+=1;
        }
        return length;
    }
}
