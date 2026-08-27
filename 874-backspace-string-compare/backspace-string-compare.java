class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb=new StringBuilder();
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(sb.length()>0)sb.deleteCharAt(sb.length()-1);
            }else
            sb.append(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(stb.length()>0)
                stb.deleteCharAt(stb.length()-1);
            }else 
            stb.append(t.charAt(i));
        }
        return sb.toString().equals(stb.toString());

    }
}