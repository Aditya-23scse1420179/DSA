class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for( int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }int max=0;
        for(int freq:map.values()){
            max=Math.max(max,freq);
        }
        return (max>1)?true:false;
    }
}