class Solution {
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String>ans=new ArrayList<>();
        helper(digits,0,"",ans);
        return ans ;
    }
    public void helper(String digit,int index,String curr,List<String>ans){
        if(index==digit.length()){
            ans.add(curr);
            return;
        }
        for(char c:map[digit.charAt(index)-'0'].toCharArray()){
            helper(digit,index+1,curr+c,ans);
        }
    }
}