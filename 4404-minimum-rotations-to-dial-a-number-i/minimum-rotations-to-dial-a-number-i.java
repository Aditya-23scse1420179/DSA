class Solution {
    public int minRotations(String s) {
        int count=0;
        count+=Math.min(10-(s.charAt(0)-'0')-0,(s.charAt(0)-'0')-0);
        for(int i=1;i<s.length();i++){
            int d=Math.abs((s.charAt(i)-'0')-(s.charAt(i-1)-'0'));
            int step=10-d;
            
            count+=Math.min(step,d);
        }
        return count;
    }
}