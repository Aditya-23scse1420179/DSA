class Solution {
    public String convertToTitle(int c) {
        StringBuilder sb=new StringBuilder();
        while(c>0){
            c--;
            sb.insert(0,(char)('A'+c%26));
            c/=26;
        }
        return sb.toString();
    }
}