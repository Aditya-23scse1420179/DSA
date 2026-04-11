class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length;i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> list = map.get(nums[i]);
            list.add(i);
            int size =list.size();
            if (size >=3){
                int a=list.get(size-3);
                int b=list.get(size-2);
                int c=list.get(size-1);
                int sum = Math.abs(a-b)+Math.abs(b -c)+Math.abs(c-a);
                min = Math.min(min,sum);
            }
        }
        return min>=(int)1e9?-1:min;
    }
}