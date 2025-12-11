class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map= new HashMap<>();
        for(String s:strs){
            char[]arr=s.toCharArray();
            Arrays.sort(arr);
            String x=new String(arr);
            map.putIfAbsent(x,new ArrayList<>());
            map.get(x).add(s);
        }
        return new ArrayList<>(map.values());
    }
}