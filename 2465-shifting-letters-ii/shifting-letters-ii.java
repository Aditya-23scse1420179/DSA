class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int []dis=new int[n+1];
        for(int []q:shifts){
            int l=q[0];
            int r=q[1];
            int d=q[2];
            if(d==0){
                dis[l]-=1;
                dis[r+1]+=1;
            }else{
                dis[l]+=1;
                dis[r+1]-=1;
            }
        }
        StringBuilder sb=new StringBuilder();
        int shift=0;
        for(int i=0;i<n;i++){
            shift+=dis[i];
            int nshift=((shift%26)+26)%26;
            char ch=s.charAt(i);
            char newchar=(char)('a'+(ch-'a'+nshift)%26);
            sb.append(newchar);
        }
        return sb.toString();
    }
}