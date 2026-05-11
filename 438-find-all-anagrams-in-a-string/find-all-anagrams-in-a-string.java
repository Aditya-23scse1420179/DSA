class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        int n=s.length();
        int k=p.length();
        char[]pu=p.toCharArray();
        Arrays.sort(pu);
        String puA=new String(pu);
        for(int i=0;i<=n-k;i++){
            String sub=s.substring(i,i+k);
            char[]sA=sub.toCharArray();
            Arrays.sort(sA);
            String su=new String(sA);
            if(puA.equals(su))ans.add(i);
        }
        return ans;
    }
}