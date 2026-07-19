class Solution {
    public String removeDuplicateLetters(String s) {
        int[]occ=new int[26];
        for(int i=0;i<s.length();i++){
            occ[s.charAt(i)-'a']=i;;
        }
        Stack<Character>st=new Stack<>();
        // Set<Character>set=new HashSet<>();
        boolean[]seen=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(seen[ch-'a'])continue;
            while(!st.isEmpty()&&ch<st.peek()&&occ[st.peek()-'a']>i){
                seen[st.pop()-'a']=false;
            }
            st.push(ch);
            seen[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}