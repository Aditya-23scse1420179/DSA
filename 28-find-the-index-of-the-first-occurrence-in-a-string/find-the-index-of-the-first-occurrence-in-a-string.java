class Solution {
    public int strStr(String h, String n) {
        if(h.length()<n.length())return -1;
        for(int i=0;i<=h.length()-n.length();i++){

            if(h.substring(i,i+n.length()).equals(n))return i;
        }
        return -1;
    }
}