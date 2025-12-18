class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x:nums){
            if (x%2==0){
                if(map.containsKey(x)){
                    map.put(x,map.get(x)+1);
                }else{
                    map.put(x,1);
                }
            }
        }
        int ans =-1;
        int maxFreq =0;
        for (int key:map.keySet()){
            int freq =map.get(key);
            if (freq >maxFreq||(freq==maxFreq&& key <ans)){
                maxFreq=freq;
                ans =key;
            }
        }
        return ans;
    }
}
