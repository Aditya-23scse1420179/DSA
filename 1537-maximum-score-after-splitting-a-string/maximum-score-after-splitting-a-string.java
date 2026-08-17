class Solution {
    public int maxScore(String s) {
        int ones=0;
        int temp=(s.charAt(0)-'0')==0?1:0;
        int score=temp;
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)-'0'==0)temp++;
            else {
                ones++;
                temp--;
            }
            if(score<temp){
                score=temp;
            }

        }
        ones+=s.charAt(s.length()-1)=='1'?1:0;
        return ones+score;
    }
}