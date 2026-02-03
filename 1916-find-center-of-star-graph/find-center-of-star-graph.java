class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int n=edges.length;
            int e=edges[0].length;
	        for(int i=0; i<=n+1; i++){
        	    adj.add(new ArrayList<>());
        	}
        	for(int i=0; i<e; i++){
            		int u = edges[i][0];
            		int v = edges[i][1];
            		adj.get(u).add(v);
            		adj.get(v).add(u);
        	}
        int max=0;
        int maxSize=0;
        for(int i=0 ; i<adj.size() ; i++){
            if(adj.get(i).size() > maxSize){
                maxSize = adj.get(i).size();
                max = i;
            }
        }
        return max;
    }
}