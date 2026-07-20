class Solution {
    int n,m;
    List<Integer>list;
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(grid[i][j]);
            }
        }
        int size=list.size();
        k%=size;
        if(k>0){
            helper(0,size-1);
            helper(0,k-1);
            helper(k,size-1);
        }
        List<List<Integer>>result=new ArrayList<>();
        int idx=0;
        for(int i=0;i<n;i++){
            List<Integer>temp=new ArrayList<>();
            for(int j=0;j<m;j++){
                temp.add(list.get(idx++));
            }
            result.add(temp);
        }
        return result;

    }public void helper(int l,int r){
        while(l<r){
            int temp=list.get(l);
            list.set(l,list.get(r));
            list.set(r,temp);
            l++;
            r--;
        }
    }
}