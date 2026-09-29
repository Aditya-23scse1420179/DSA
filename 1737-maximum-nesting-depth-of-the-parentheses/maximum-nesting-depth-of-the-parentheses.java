class Solution {
    public int maxDepth(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            int count=0;
            // if(Character.isDigit(s.charAt(i))){
                for(int j=0;j<i;j++){
                    if(s.charAt(j)=='('){
                        count++;
                    }
                    else if(s.charAt(j)==')')count--; 
                }
                max=Math.max(max,count);
            // }
        }
        return max;
    }
}