class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer>list=new ArrayList<>();
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+high>>1;
            if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        int l=low-1;
        int r=low;
        while(r-l-1<k){
            if(l<0){//left khatam right se element lo 
                r++;
            }else if(r>=arr.length){//right khatam left se lo 
                l--;
            }else{
                if(Math.abs(arr[l]-x)<=Math.abs(arr[r]-x)){
                    l--;
                }else{
                    r++;
                }
            }
        }
        for(int i=l+1;i<r;i++){
            list.add(arr[i]);
        }
        return list;


    }
}