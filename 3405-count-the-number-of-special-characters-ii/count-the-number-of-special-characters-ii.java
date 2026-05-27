class Solution {
    public int numberOfSpecialChars(String word) {
        int[]first=new int[26];
        Arrays.fill(first,-1);
    
        int[]last=new int[26];
        Arrays.fill(last,-1);

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch)){
                last[ch-'a']=i;
            }
            else{
                if(first[ch-'A']==-1){
                    first[ch-'A']=i;
                }
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(first[i]!=-1&&last[i]!=-1&&last[i]<first[i])count++;
        }
        return count;
    }
}