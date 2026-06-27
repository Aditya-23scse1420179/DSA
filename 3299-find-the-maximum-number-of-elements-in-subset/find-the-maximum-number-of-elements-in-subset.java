class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer>map=new HashMap<>();
        for(int x:nums){
            map.put((long)x,map.getOrDefault((long)x,0)+1);
        }int maxlen=0;
        if(map.containsKey(1L)){
            maxlen=Math.max(maxlen,map.get(1L)%2==0?map.get(1L)-1:map.get(1L));
        }
        for(long x:map.keySet()){
            if(x==1)continue;
            long curr=x;
            int len=0;
            while(map.containsKey(curr)){
                if(map.get(curr)>=2){
                    len+=2;
                    curr=curr*curr;
                }else{
                    len++;
                    break;
                }
            }
            if(len%2==0)len--;
            maxlen=Math.max(maxlen,len);
        }
        return maxlen;
    }
}