class Solution {
    public int largestInteger(int[] nums, int k) {
        int[]arr=new int[nums.length];
        int id=0;
        for(int a:nums){
            arr[id++]=a;
        }
        Arrays.sort(arr);
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(i>0&&arr[i]==arr[i-1])continue;
            int e=arr[i];
            int l=0,r=k-1;
            while(r<nums.length){
                boolean found =false;
                for(int x=l;x<=r;x++){
                    if(e==nums[x]){
                        found=true;
                        break;
                    }
                }
                if(found){
                    map.put(e,map.getOrDefault(e,0)+1);
                }
                l++;
                r++;
            }
        }
        int max=-1;
        for(int x:map.keySet()){
            if(map.get(x)==1){
                max=Math.max(x,max);
            }
        }
        return max;
    }
}