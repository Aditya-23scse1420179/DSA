class Solution {
    public int takeCharacters(String s, int k) {
        int[]freq=new int[3];
        for(char x:s.toCharArray()){
            freq[(int)x-'a']++;
        }
        for(int a:freq){
            if(a<k)return -1;
        }
        int[]cnt=new int[3];
        int l=0;
        int m=0;
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
            while(cnt[0]>freq[0]-k||cnt[1]>freq[1]-k||cnt[2]>freq[2]-k){
                cnt[s.charAt(l)-'a']--;
                l++;
            }
            m=Math.max(m,i-l+1);
        }
        return s.length()-m;
    }
}