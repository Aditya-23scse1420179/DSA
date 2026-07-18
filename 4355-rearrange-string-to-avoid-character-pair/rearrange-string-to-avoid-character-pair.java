class Solution {
    public String rearrangeString(String s, char x, char y) {
        int[]freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        while(freq[y-'a']-->0){
            sb.append(y);
        }
        for(char c:s.toCharArray()){
            if(c==y)continue;
            sb.append(c);
        }
        return sb.toString();
    }
}