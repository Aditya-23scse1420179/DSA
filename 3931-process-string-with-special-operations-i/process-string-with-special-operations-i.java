class Solution {
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLowerCase(s.charAt(i))){
                sb.append(s.charAt(i));
            }else if(s.charAt(i)=='*'){
                if(sb.length()>=1) sb.deleteCharAt(sb.length()-1);
            }else if(s.charAt(i)=='#'){
                sb.append(sb.toString());
            }else if(s.charAt(i)=='%'){
                sb.reverse();
            }
        
        }
        return sb.toString();
    }
}