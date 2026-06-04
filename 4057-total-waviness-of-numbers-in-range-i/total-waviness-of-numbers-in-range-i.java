class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num2<100)return 0;
        int ans=0;
        for(int p=num1;p<=num2;p++){
            String s=p+"";
            for(int i=1;i<s.length()-1;i++){
                ans+=valley(s.charAt(i-1)-'0',s.charAt(i)-'0',s.charAt(i+1)-'0');
            }
        }
        return ans;
    }public int valley(int prev,int curr,int nxt){
        int count=0;
        if(prev<curr&&curr>nxt)count++;
        else if(prev>curr&&curr<nxt)count++;
        
        return count;
    }
}