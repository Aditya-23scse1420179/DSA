class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target)return 0;
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->b-a);
        int i=0,stop=0,maxDist=startFuel;
        while(maxDist<target){
            while(i<stations.length&&stations[i][0]<=maxDist){
                q.offer(stations[i++][1]);
            }
            if(q.isEmpty())return -1;
            maxDist+=q.poll();
            stop++;
        }
        return stop;
    }
}