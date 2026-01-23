class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>freq=new HashMap<>();
        for(String w:words){
            freq.put(w,freq.getOrDefault(w,0)+1);
        }
        List<String>list=new ArrayList<>(freq.keySet());
        Collections.sort(list,(a,b)->{
            int f1=freq.get(a),f2=freq.get(b);
            if(f1==f2)return a.compareTo(b);
            return f2-f1;
        });
        return list.subList(0,k);
    }
}