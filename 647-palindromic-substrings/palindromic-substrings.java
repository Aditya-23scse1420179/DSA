class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            String sub="";
            for(int j=i;j<n;j++){
                sub+=s.charAt(j);
                if(ispal(sub))count++;
            }
        }
        return count;
    }public boolean ispal(String sub){
        int i=0,j=sub.length()-1;
        while(i<j){
            if(sub.charAt(i)!=sub.charAt(j))return false;
            i++;
            j--;
        }
        return true;

    }
}