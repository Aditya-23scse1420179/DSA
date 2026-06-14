class Solution {
    public int getLength(int[] nums) {
        int n=nums.length;
        int res=1;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> freq=new HashMap<>();
            Map<Integer,Integer> freqcount=new HashMap<>();
            int max=0;
            for(int j=i;j<n;j++){
                int num=nums[j];
                int before=freq.getOrDefault(num,0);
                if(before>0){
                    freqcount.put(before,freqcount.get(before)-1);
                    if(freqcount.get(before)==0){
                        freqcount.remove(before);
                    }}
                    int curr=before+1;
                    freq.put(num,curr);
                    freqcount.put(curr,freqcount.getOrDefault(curr,0)+1);
                    max=Math.max(max,curr);
                    if(isbalance(freq.size(),freqcount,max)){
                        res=Math.max(res,j-i+1);
                    }
                
            }
        }
        return res;
    }
    public boolean isbalance(int size,Map<Integer,Integer> freqcount,int max){
        if(size==1){
            return true;
        }
        int maxnum=freqcount.getOrDefault(max,0);
        if(maxnum==size){
            return false;
        }
        if(max%2!=0){
            return false;
        }
        int rem=freqcount.getOrDefault(max/2,0);
        return maxnum+rem==size;
    }
}