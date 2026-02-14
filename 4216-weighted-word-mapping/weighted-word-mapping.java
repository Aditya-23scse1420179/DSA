class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            int ans=0;
            for(char ch:word.toCharArray()){
                ans+=weights[ch-'a'];
            }
            int res=ans%26;
            char map=(char)('z'-res);
            sb.append(map);
        }
        return sb.toString();
    }
}