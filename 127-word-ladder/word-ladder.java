class Solution {
    static class pair{
        String s;
        int level;
        public pair(String s,int level){
            this.s=s;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair>q=new LinkedList<>();
        HashSet<String>set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }if(!set.contains(endWord))return 0;
        set.remove(beginWord);
        q.offer(new pair(beginWord,1));
        while(!q.isEmpty()){
            pair curr=q.remove();
            String a=curr.s;
            int l=curr.level;
            if(a.equals(endWord))return l;
            for(int i=0;i<a.length();i++){
                char[]arr=a.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    if(arr[i]==ch)continue;
                    arr[i]=ch;
                    String replace=new String(arr);
                    if(set.contains(replace)){
                        q.offer(new pair(replace,l+1));
                        set.remove(replace);
                    }
                }
            }
        }
        return 0;
    }
} 