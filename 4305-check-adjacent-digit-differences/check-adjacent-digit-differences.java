class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {

        for(int i=1;i<s.length();i++){
            int diff=Math.abs(s.charAt(i-1)-s.charAt(i));
            if(diff>2)return false;
        }
        return true;
    }
}