class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1)return 1;
        int[]freq=new int[256];
        for(char c:s.toCharArray()){
            freq[c]++;
        }int count=0,odd=0;
        for(int a:freq){
            if(a%2==0)count+=a;
            else {
                count+=a-1;
                odd=1;
            }
        }
        return odd+count;
    }
}