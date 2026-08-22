class Solution {
    public int longestPalindrome(String[] words) {
        int[][]freq=new int[26][26];
        int ans=0;
        for(String w:words){
            int a=w.charAt(0)-'a',b=w.charAt(1)-'a';
            if(freq[b][a]>0){
                ans+=4;
                freq[b][a]--;
            }else freq[a][b]++;
        }
        for(int i=0;i<26;i++){
            if(freq[i][i]>0){
                ans+=2;
                break;
            }
        }
        return ans;
    }
}