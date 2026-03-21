class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int l=n/3;
        Map<Integer,Integer>map=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>l){
                ans.add(key);
            }
        }
        return ans;
    }
}