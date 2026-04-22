class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String>list=new ArrayList<>();
        for(String ch:queries){
            
            for(String a:dictionary){
                int count=0;
                for(int i=0;i<ch.length();i++){
                    if(ch.charAt(i)!=a.charAt(i))count++;
                }
                if(count<=2){
                    list.add(ch);
                    break;
                }
            }
        }
        return list;
    }
}