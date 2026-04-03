class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        HashMap<Character ,Integer>map=new HashMap<>();
        int max=0,left=0,ans=0;
        for(int i=0;i<answerKey.length();i++){
            map.put(answerKey.charAt(i),map.getOrDefault(answerKey.charAt(i),0)+1);
        
            max=Math.max(max,map.get(answerKey.charAt(i)));
            while((i-left+1)-max>k){
                char leftch=answerKey.charAt(left);
                map.put(leftch,map.get(leftch)-1);
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;

    }
}