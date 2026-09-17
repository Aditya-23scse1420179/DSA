class Solution {
    public int characterReplacement(String s, int k) {
        int[]ch=new int[256];
        int max=0,ca=0,cb=0,l=0,ans=0;
        for(int i=0;i<s.length();i++){
            ch[s.charAt(i)-'A']++;
            max=Math.max(max,ch[s.charAt(i)-'A']);
            while((i-l+1)-max>k){
                ch[s.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(ans,i-l+1);
        }
        return ans;
    }
}