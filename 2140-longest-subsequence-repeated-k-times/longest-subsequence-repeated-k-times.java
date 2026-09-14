class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String ans="";
        Queue<String>q=new LinkedList<>();
        q.add("");
        while(!q.isEmpty()){
            String curr=q.poll();
            for(char ch='a';ch<='z';ch++){
                String nxt=curr+ch;
                if(helper(nxt,s,k)){
                    ans=nxt;
                    q.add(nxt);
                }
            }
        } 
        return ans;
    }public boolean helper(String sub,String s,int k){
        int i=0,count=0;
        for(char ch:s.toCharArray()){
            if(ch==sub.charAt(i)){
                i++;
                if(i==sub.length()){
                    i=0;
                    count++;
                    if(count==k)return true;
                }
            }
        }
        return false;
    }
}