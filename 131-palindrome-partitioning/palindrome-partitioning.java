class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        helper(s,ans,new ArrayList<>(),0);
        return ans;
    }public void helper(String s,List<List<String>>ans,List<String>list,int idx){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
        }
        for(int i=idx+1;i<=s.length();i++){
            if(ispal(s,idx,i-1)){
                list.add(s.substring(idx,i));
                helper(s,ans,list,i);
                list.remove(list.size()-1);
            }
        }
    }public boolean ispal(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
        }
        return true;
    }
}