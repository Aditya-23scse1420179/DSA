class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
       
        List<Integer>ans=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
            if(map.get(a)<=k){
                ans.add(a);
            }
        } int[]arr=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}