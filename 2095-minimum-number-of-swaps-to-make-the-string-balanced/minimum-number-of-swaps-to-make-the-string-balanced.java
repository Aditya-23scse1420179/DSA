class Solution {
    public int minSwaps(String s) {
        int o=0;
        for(char c:s.toCharArray()){
            if(c=='[')o++;
            else {
                if(o>0){
                    o--;
                }
            }
        }
        return (o+1)/2;
        
    }
}