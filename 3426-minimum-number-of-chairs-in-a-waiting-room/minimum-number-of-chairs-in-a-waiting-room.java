class Solution {
    public int minimumChairs(String s) {
        int n=s.length();
        int[]arr=new int[n];
        arr[0]=1;
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='E'){
                arr[i]=arr[i-1]+1;
            }else {
                arr[i]=arr[i-1]-1;
            }
        }int max=0;
        for(int a:arr){
            max=Math.max(max,a);
            System.out.print(a);
        }
        return max;
    }
}