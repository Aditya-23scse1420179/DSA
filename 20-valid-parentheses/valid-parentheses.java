class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(char c:s.toCharArray()){
            char ch=c;
            if(ch=='('||ch=='{'||ch=='[')st.push(ch);
            else {
                if(st.isEmpty())return false;
                char x=st.pop();
                if(ch==')'&&x!='(')return false;
                if(ch=='}'&&x!='{')return false;
                if(ch==']'&&x!='[')return false;
            }
        }
        return st.isEmpty();
    }
}