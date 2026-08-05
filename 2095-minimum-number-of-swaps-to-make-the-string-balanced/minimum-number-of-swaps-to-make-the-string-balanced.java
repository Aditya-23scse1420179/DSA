class Solution {
    public int minSwaps(String s) {
        int o=0,b=0;
        for(char c:s.toCharArray()){
            if(c=='[')o++;
            else {
                o--;
            }
            if(o<0){
                b++;
                o=1;
            }
        }
        return b;
        
    }
}