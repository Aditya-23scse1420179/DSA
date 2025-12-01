class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String>ans = new ArrayList<>();
        ans.add("");
        for(char c: s.toCharArray()){
            int size = ans.size();
            if(Character.isDigit(c)){
                for(int i=0;i<size;i++){
                    ans.set(i,ans.get(i)+c);
                }
            }else{
                List<String>temp= new ArrayList<>();
                for(int i=0;i<size;i++){
                    temp.add(ans.get(i)+Character.toLowerCase(c));
                    temp.add(ans.get(i)+Character.toUpperCase(c));
                }
                ans = temp;
            }

        }
        return ans ;
    }
}