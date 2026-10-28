class Solution {
    public int calculateScore(int a, int b) {
        String s1=Integer.toBinaryString(a);
        String s2=Integer.toBinaryString(b);
        int c1=0,c2=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='1')c1++;
        }
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)=='1')c2++;
        }
        return c1>=c2?c1*c2:c2/c1;
    }
}