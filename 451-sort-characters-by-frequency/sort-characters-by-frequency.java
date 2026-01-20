class Solution {
    public String frequencySort(String s) {
        return helper(s);
    }public static String helper(String s){
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>list=new ArrayList<>(map.keySet());
        list.sort((a,b)->map.get(b)-map.get(a));
        StringBuilder sb=new StringBuilder();
        for(char a:list){
            int freq=map.get(a);
            while(freq-->0){
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
