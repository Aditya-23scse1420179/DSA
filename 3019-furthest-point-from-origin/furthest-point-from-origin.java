class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n=moves.length(),cl=0,cr=0,cd=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L')cl++;
            else if(moves.charAt(i)=='_')cd++;
            else cr++;
        }
        if(cl>cr){
            return cl+cd-cr;
        }else{
            return cr+cd-cl;
        }
    }
}