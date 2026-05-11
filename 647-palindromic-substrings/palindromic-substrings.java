class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
           count+=ispal(s,i,i);
           count+=ispal(s,i,i+1);
        }
        return count;
    }public int ispal(String sub,int i,int j){
        int count=0;
        while(i>=0&&j<sub.length()){
            if(sub.charAt(i)==sub.charAt(j)){
                count++;
                i--;
                j++;
            }
            else break;
        }
        return count;

    }
}