class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int curr=0;
        int max=0;
        int n=tokens.length-1;
        int i=0;int j=n;
        while(i<=j){
            if(power>=tokens[i]){
                        power-=tokens[i++];
                      curr++;
                    }
            else if(curr>0){
                power+=tokens[j];
                curr-=1;
                j--;
            }
            else 
            break;
            max=Math.max(curr,max);
            }
        return max;
    }
}