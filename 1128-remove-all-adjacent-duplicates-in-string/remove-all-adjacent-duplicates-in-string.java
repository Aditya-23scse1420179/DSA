class Solution {
    public String removeDuplicates(String s) {
        Stack<Character>st=new Stack<>();
        for(char x:s.toCharArray()){
            if(!st.isEmpty()&&st.peek()==x){
                st.pop();
                continue;
            }
            st.push(x);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}