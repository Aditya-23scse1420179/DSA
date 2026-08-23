class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int l, int u) {
        List<Integer>list=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        for(int i=l;i<=u;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        if(list.isEmpty())return res;
        int start=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)!=list.get(i-1)+1){
                res.add(Arrays.asList(start,list.get(i-1)));
                start=list.get(i);
            }
        }
        res.add(Arrays.asList(start,list.get(list.size()-1)));
        return res;
    }
}