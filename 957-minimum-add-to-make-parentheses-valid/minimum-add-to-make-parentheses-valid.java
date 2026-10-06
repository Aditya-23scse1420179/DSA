class Solution {
    public int minAddToMakeValid(String s) {
        int o=0,a=0;
        for (char ch:s.toCharArray()) {
            if (ch=='(')o++;
            else if(o>0)o--;  
            else a++; 
        }
        return a+o; 
    }
}