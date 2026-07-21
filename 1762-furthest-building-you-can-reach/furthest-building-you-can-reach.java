class Solution {
    public int furthestBuilding(int[] h, int br, int l) {
       PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->a-b);
       for(int i=0;i<h.length-1;i++){
        int diff=h[i+1]-h[i];
       
        if(diff>0){
            q.add(diff);
            if(q.size()>l){
                br-=q.poll();
                if(br<0)return i;
            }
        }
       }
        return h.length-1;
    
    }
}