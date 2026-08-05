class Solution {
    public int minSwaps(String s) {
        int o=0,b=0;
        for(char c:s.toCharArray()){
            if(c=='[')o++;
            else {
                o--;
            }
            if(o<0){// Agar balance negative ho gaya, matlab extra ']' aa gaya
                b++;// 1. Ek swap badha do
                o=1;// 2. Swap karne ke baad wo ']' ab '[' ban gaya, toh balance 1 kar do
            }
        }
        return b;
        
    }
}