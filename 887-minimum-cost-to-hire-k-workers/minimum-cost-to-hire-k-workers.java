class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        double res=1e18;
        double[][]workers=new double[n][2];
        for (int i =0;i<n;i++){
            workers[i][0]=(double) wage[i]/quality[i]; 
            workers[i][1]=quality[i];
        }
        Arrays.sort(workers,(a,b)->Double.compare(a[0],b[0]));
        PriorityQueue<Double>pq =new PriorityQueue<>(Collections.reverseOrder());
        double sumQuality=0;
        for (int i =0;i<n;i++){
            double q=workers[i][1];
            pq.add(q);
            sumQuality+=q;
            if (pq.size()>k) {
                sumQuality-=pq.poll();
            }
            if (pq.size()==k){
                res=Math.min(res,workers[i][0]*sumQuality);
            }
        }

        return res;
    }
}