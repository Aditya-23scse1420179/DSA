class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->b-a);
        for(int a:stones){
            q.offer(a);
        }
        while(q.size()>1){
            int a=q.poll();
            int b=q.poll();
            if(a!=b)q.offer(a-b);
        }
        return q.size()==0?0:q.poll();
    }
}