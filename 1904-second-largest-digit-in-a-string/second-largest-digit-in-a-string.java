class Solution {
    public int secondHighest(String s) {
        int f=-1,si=-1;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                if(ch>f){
                    si=f;
                    f=ch;
                }else if(ch!=f&&ch>si){
                    si=ch;
                }
            }
        }
        return si==-1?-1:si-'0';
    }
}