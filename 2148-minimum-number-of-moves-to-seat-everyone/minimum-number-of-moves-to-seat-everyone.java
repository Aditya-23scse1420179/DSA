class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        helper(seats);
        helper(students);
        int sum=0;
        for(int i=0;i<seats.length;i++){
            sum+=Math.abs(seats[i]-students[i]);
        }
        return sum;
    }public void helper(int[]arr){
        int min=(int)1e9,max=-(int)1e9;
        for(int x:arr){
            min=Math.min(x,min);
            max=Math.max(x,max);
        }
        int[]freq=new int[max-min+1];
        for(int a:arr){
            freq[a-min]++;
        }int idx=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                arr[idx++]=i+min;
                freq[i]--;
            }
        }
    }
}