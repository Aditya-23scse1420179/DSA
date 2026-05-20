class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[]arr=new int[A.length];
        Set<Integer>set=new HashSet<>();
        set.add(A[0]);
        arr[0]=A[0]==B[0]?1:0;
        for(int i=1;i<A.length;i++){
            int count=0;
            set.add(A[i]);
            for(int j=0;j<=i;j++){
                if(set.contains(B[j]))count++;
            }
            arr[i]=count;
        }
        return arr;
    }
}