class Solution {
    public String removeDuplicateLetters(String s) {
        int[]occ=new int[26];
        for(int i=0;i<s.length();i++){
            occ[s.charAt(i)-'a']=i;;
        }
        Stack<Character>st=new Stack<>();
        Set<Character>set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch))continue;
            while(!st.isEmpty()&&ch<st.peek()&&occ[st.peek()-'a']>i){
                set.remove(st.pop());
            }
            st.push(ch);
            set.add(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}