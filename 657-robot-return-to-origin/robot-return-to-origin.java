class Solution {
    public boolean judgeCircle(String moves) {
        int ans=0;
        for(char ch:moves.toCharArray()){
            if(ch=='U')ans+=1;
            else if(ch=='D')ans+=-1;
            else if(ch=='L')ans+=100;
            else ans+=-100;
        }
        return ans==0?true:false;
    }
}