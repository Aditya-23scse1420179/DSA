class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Arrays.sort(arr);
    Map<Integer, Integer> freq = new HashMap<>();
    for (int x:arr) {
        freq.put(x,freq.getOrDefault(x,0)+1);
    }
    List<Integer> sortedKeys=new ArrayList<>(freq.keySet());
    Collections.sort(sortedKeys);
    int idx = 0;
    for(int key:sortedKeys) {
        int count=freq.get(key);
        while(count-->0) {
            arr[idx++]= key;
        }
    }
        int res=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=res+1)res++;
        }
        return res;
    }
}