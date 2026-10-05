class Solution {
    public int scoreOfParentheses(String s) {
        int count=0,d=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                ++d;

            }else{
                --d;
                if(s.charAt(i-1)=='('){
                    count+=1<<d;
                }
            }
        }
        return count;
    }
}