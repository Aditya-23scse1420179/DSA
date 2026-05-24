class Solution {
    public int passwordStrength(String p) {
        int score=0;
        Set<Character>set=new HashSet<>();
        for(char c:p.toCharArray()){
            set.add(c);
        }

        for(char ch:set){
            if(Character.isUpperCase(ch))score+=2;
            else if(Character.isLowerCase(ch))score+=1;
            else if(Character.isDigit(ch))score+=3;
            else{
                score+=5;
            }
        }
        return score;
    }
}