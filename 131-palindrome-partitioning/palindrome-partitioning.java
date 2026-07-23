class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>list=new ArrayList<>();
        helper(s,list,new ArrayList<>(),0);
        return list;
    }public void helper(String s,List<List<String>>list,List<String>temp,int start){
        if(start==s.length()){
            list.add(new ArrayList<>(temp));
        }
        for(int i=start+1;i<=s.length();i++){
            if(ispal(s,start,i-1)){
                temp.add(s.substring(start,i));
                helper(s,list,temp,i);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean ispal(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}