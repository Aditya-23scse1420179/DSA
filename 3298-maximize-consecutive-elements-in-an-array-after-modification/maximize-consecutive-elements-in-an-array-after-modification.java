class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            map.put(x+1,map.getOrDefault(x,0)+1);
            map.put(x,map.getOrDefault(x-1,0)+1);
            max=Math.max(max,Math.max(map.get(x),map.get(x+1)));
        }
        return max;
    }
}