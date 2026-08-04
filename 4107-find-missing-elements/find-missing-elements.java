class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer>set=new HashSet<>();
        int min=(int)1e9,max=0;
        for(int a:nums){
            min=Math.min(min,a);
            max=Math.max(a,max);
            set.add(a);
        }
        List<Integer>list=new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!set.contains(i))list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}