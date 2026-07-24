class Solution {
    public int minimumChairs(String s) {
        int n=s.length();
        int cnt=0,ch=0;
        for(char a:s.toCharArray()){
            if(a=='E'){
                cnt++;
                if(cnt>ch){
                    ch=cnt;
                }
            }
            else{
                cnt--;
            }
        }
        return ch;
    }
}