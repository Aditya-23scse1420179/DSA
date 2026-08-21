class Solution {
    public int minimumRecolors(String s, int k) {
        int min=(int)1e9;
        int i=0;
        int w=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='W')w++;
            while(j-i+1>k){
                if(s.charAt(i)=='W')w--;
                i++;
            }
            if(j-i+1==k)min=Math.min(min,w);
        }
        return min;
    }
}