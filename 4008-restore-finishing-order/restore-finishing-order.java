class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer>set=new HashSet<>();
        for(int a:friends){
            set.add(a);
        }int idx=0;
        for(int i=0;i<order.length;i++){
            if(set.contains(order[i])){
                friends[idx++]=order[i];
            }
        }
        return friends;
    }
}