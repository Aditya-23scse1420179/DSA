class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String w :words) {
            if (isSubsequence(s,w)) {
                count++;
            }
        }
        return count;
    }
    private boolean isSubsequence(String s, String w) {
        int idx=0;   
        for(char ch:w.toCharArray()){
            int i=s.indexOf(ch,idx);
            if(i==-1)return false;
            idx=i+1;
        }
        return true;
        
    }

}
