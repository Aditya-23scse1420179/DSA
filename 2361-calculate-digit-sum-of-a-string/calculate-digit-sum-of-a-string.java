class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb=new StringBuilder();
            int i=0,j=k-1;
            while(i<s.length()){
                int sum=0;
                for(int x=i;x<=j;x++){
                    sum+=s.charAt(x)-'0';
                }
                sb.append(sum);
                i=j+1;
                if(j+k>=s.length())j=s.length()-1;
                else j=i+k-1;
            }
            s=sb.toString();
        }
        return s;
    }
}