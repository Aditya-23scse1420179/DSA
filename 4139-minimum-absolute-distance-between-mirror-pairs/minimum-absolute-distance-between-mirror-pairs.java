class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int count=(int)1e9;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                count=Math.min(count,i-map.get(nums[i]));
            }
            int re=rev(nums[i]);
            
            map.put(re,i);
        }
        return count>=(int)1e9?-1:count;
    }public int rev(int num ){
        int rev=0;
        while(num>0){
            rev=rev*10+num%10;
            num/=10;
        }
        return rev;
    }
}