class Solution {
    public int minimumRecolors(String s, int k) {
        int min=(int)1e9;
        int i=0,j=k-1,w=0;
        while(j<s.length()){
            for(int x=i;x<=j;x++){
                if(s.charAt(x)=='W')w++;
            }
            min=Math.min(min,w);
            i++;
            j++;
            w=0;
        }
        return min;
    }
}