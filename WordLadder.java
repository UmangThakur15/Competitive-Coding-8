import java.util.*;

//TC will be O(k * 26^k)
//SC will be O(k * 26^k)
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord); q.add(null);
        HashSet<String> vis=new HashSet<>();
        vis.add(beginWord);
        int lvl=1;
        while(!q.isEmpty()) {
            String pop=q.poll();
            if(pop==null){
                lvl++;
                if(!q.isEmpty()) q.add(null);
            }else{
                char[] str=pop.toCharArray();
                for(int i=0;i<str.length; str[i]=pop.charAt(i), i++){
                    for(char a='a';a<='z';a++){
                        str[i]=a;
                        String neigh=new String(str);
                        if(set.contains(neigh) && !vis.contains(neigh)){
                            if(neigh.equals(endWord)) return lvl+1;
                            vis.add(neigh);
                            q.add(neigh);
                        }
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        WordLadder obj = new WordLadder();
        System.out.println(obj.ladderLength(beginWord,endWord,wordList));
    }
}