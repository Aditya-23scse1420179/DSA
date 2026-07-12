class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        String s=Integer.toBinaryString(start);
        String g=Integer.toBinaryString(goal);
        int i=s.length()-1,j=g.length()-1;
        while(i>=0&&j>=0){
            if(s.charAt(i)!=g.charAt(j))count++;
            i--;
            j--;
        }
        while(i>=0){
            if(s.charAt(i)=='1')count++;
            i--;
        }
        while(j>=0){
            if(g.charAt(j)=='1')count++;
            j--;
        }
        return count;
    }
}