class Solution {
    public String smallestSubsequence(String s) {
        int[]last=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        Stack<Character>st=new Stack<>();
        boolean[]seen=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(seen[ch-'a'])continue;
            while(!st.isEmpty()&&ch<st.peek()&&last[st.peek()-'a']>i){
                seen[st.pop()-'a']=false;
            }
            st.push(ch);
            seen[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())sb.append(st.pop());
        return sb.reverse().toString();



    }
}