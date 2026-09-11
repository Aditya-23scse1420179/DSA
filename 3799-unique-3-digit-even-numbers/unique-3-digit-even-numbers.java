class Solution {
    public int totalNumbers(int[] n) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n.length;i++){
            if(n[i]==0)continue;
            for(int j=0;j<n.length;j++){
                if(i==j)continue;
                for(int k=0;k<n.length;k++){
                    if(k==i||k==j)continue;
                    if(n[k]%2==0){
                        int ans=n[i]*100+n[j]*10+n[k];
                        set.add(ans);
                    }
                }
            }
        }
        return set.size();
    }
}