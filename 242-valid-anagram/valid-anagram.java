class Solution {
    public boolean isAnagram(String s1, String s2) {
        int[]f1=new int[26];
        int[]f2=new int[26];
        for(char a:s1.toCharArray()){
            f1[a-'a']++;
        }
        for(char a:s2.toCharArray()){
            f2[a-'a']++;
        }
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i])return false;
        }
        return true;
    }
}