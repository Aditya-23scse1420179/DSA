class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[]freq=new int[24];
        long count=0;
        for(int a:hours){
            int d=(24-a%24)%24;
            count+=freq[d];
            freq[a%24]++;
        }
        return count;
    }
}