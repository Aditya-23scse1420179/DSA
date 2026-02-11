class Solution {
    static class pair{
        String str;
        int level;
        public pair(String str,int level){
            this.str=str;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>set=new HashSet<>();
        for(String wd:wordList){
            set.add(wd);
        }set.remove(beginWord);
        if(!set.contains(endWord)){
            return 0;
        }Queue<pair>q=new LinkedList<>();
        q.offer(new pair(beginWord,1));
        while(!q.isEmpty()){
            pair curr=q.remove();
            String s=curr.str;
            int step=curr.level;
            if(s.equals(endWord))return step;
            int len=s.length();
            for(int i=0;i<len;i++){
                char[]arr=s.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    if(arr[i]==ch)continue;
                    arr[i]=ch;
                    String replace=new String(arr);
                    if(set.contains(replace)){
                        q.offer(new pair(replace,step+1));
                        set.remove(replace);
                    }
                }
            }
        }
        return 0;

    }
}