class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder str=new StringBuilder();
        for(char a:s.toCharArray()){
            str.append(String.format("%8s",Integer.toBinaryString(a)).replace(' ','0'));
        }
        return ispal(str.toString());
    }public boolean ispal(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
        }
        return true;
    }
}