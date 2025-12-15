class Solution {
    public String reverseWords(String s) {
        String[]words=s.split(" ");
        int count=countvowels(words[0]);
        for(int i=1;i<words.length;i++){
            if(countvowels(words[i])==count){
                words[i]=new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ",words);
    }
    public int countvowels(String words){
        int vowel=1;
        for(char c:words.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                vowel++;
            }
        }
        return vowel;
    }
}