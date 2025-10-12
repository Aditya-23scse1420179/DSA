class Solution {
    public int getLeastFrequentDigit(int n) {
        Map<Integer, Integer> freq =new HashMap<>();
        String numStr=String.valueOf(n);
        for (char c:numStr.toCharArray()) {
            int digit=c-'0';
            freq.put(digit,freq.getOrDefault(digit,0)+1);
        }
        int minFreq=Collections.min(freq.values());
        int ans=9; 
        for (int d :freq.keySet()) {
            if (freq.get(d)==minFreq) {
                ans = Math.min(ans,d);
            }
        }
        return ans;
    }
}
