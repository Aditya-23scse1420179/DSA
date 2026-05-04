class Solution {
    List<List<String>>res=new ArrayList<>();
    List<String>list=new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,0);
        return res;
    }public void helper(String s,int start){
        if(start==s.length()){
            res.add(new ArrayList<>(list));
        }
        for(int i=start+1;i<=s.length();i++){
            if(ispal(s,start,i-1)){
                list.add(s.substring(start,i));
                helper(s,i);
                list.remove(list.size()-1);
            }
        }
    }public boolean ispal(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
            
        }
        return true;
    }
}