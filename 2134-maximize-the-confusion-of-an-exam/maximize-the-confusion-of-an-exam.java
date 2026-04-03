class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max=0,cT=0,cF=0,left=0,ans=0;
        for(int right=0;right<answerKey.length();right++){
            if(answerKey.charAt(right)=='T')cT++;
            else cF++;
            max=Math.max(cT,cF);
            while((right-left+1)-max>k){
                if(answerKey.charAt(left)=='T')cT--;
                else cF--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;

    }
}