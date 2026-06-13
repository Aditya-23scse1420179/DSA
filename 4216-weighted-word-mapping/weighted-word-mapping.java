class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        HashMap<Integer,Character>map=new HashMap<>();
        for (int i=0;i< 26;i++) {
            map.put(i,(char)('z'-i));
        }
        int sum=0;
        for(String s:words){
            for(int i=0;i<s.length();i++){
                sum+=weights[s.charAt(i)-'a'];
            }
            sum%=26;
            sb.append(map.get(sum));
            sum=0;
        }
        return sb.toString();
        
    }
}