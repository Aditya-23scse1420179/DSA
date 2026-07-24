class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        double res=1e18;
        double[][]workers=new double[n][2];
        for (int i=0;i<n;i++){
            workers[i][0]=(double)wage[i]/quality[i]; 
            workers[i][1]=quality[i];
        }
        Arrays.sort(workers,(a,b)->Double.compare(a[0],b[0]));
    
        PriorityQueue<Double>q=new PriorityQueue<>(Collections.reverseOrder());
        double ans=0;
        for(int i=0;i<n;i++){
            double r=workers[i][1];
            q.add(r);
            ans+=r;
            if(q.size()>k){
                ans-=q.poll();
            }
            if(q.size()==k){
                res=Math.min(res,workers[i][0]*ans);
            }
        }
        return res;
    }
}