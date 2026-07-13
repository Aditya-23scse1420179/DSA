class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer>q=new LinkedList<>();
        List<Integer>list=new ArrayList<>();
        for(int i=1;i<=8;i++){
            q.offer(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            if(curr>=low&&curr<=high){
                list.add(curr);
            }
            int d=curr%10;
            if(d+1<=9){
                q.offer((curr*10)+(d+1));
            }
        }
        return list;
    }
}