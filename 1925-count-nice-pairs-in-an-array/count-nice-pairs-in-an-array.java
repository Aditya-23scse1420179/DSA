class Solution {
    public int countNicePairs(int[] nums) {
        long count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            int d=x-rev(x);
            if(map.containsKey(d))count=(count+map.get(d))%1000000007;
            map.put(d,map.getOrDefault(d,0)+1);
        }
        return (int)count;
    }public int rev(int x){
        int rev=0;
        while(x>0){
            rev=rev*10+x%10;
            x/=10;
        }
        return rev;
    }
}