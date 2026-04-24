class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:moves.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int l=map.getOrDefault('L',0);
        int r=map.getOrDefault('R',0);
        int d=map.getOrDefault('_',0);
        if(l>r){
            return l+d-r;
        }else{
            return r+d-l;
        }
    }
}