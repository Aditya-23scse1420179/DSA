class Solution {
    public long sumAndMultiply(int n) {
        if(n==0)return 0;
        String s=String.valueOf(n);
        int sum=0;
        StringBuilder sb=new StringBuilder();
        for(char a:s.toCharArray()){
            if(a!='0'){
                sb.append(a);
                sum+=a-'0';
            }
        }
        long ans=Long.parseLong(sb.toString());
        return sum*ans;
    }
}