class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> hs = new HashSet<String>();
        for(String word : wordList) {
            hs.add(word);
        }

        if (!hs.contains(endWord))
            return 0;


        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        hs.remove(beginWord);

        int words = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String str = q.poll();

                if (str.equals(endWord))
                    return words;

                char[] arr = str.toCharArray();
                for(int j=0; j<arr.length; j++) {
                    char original = arr[j];
                    for(char k='a'; k<='z'; k++) {
                        if (k == original)
                            continue;

                        arr[j] = k;
                        String modifiedStr = new String(arr);
                        if (hs.contains(modifiedStr)) {
                            q.add(modifiedStr);
                            hs.remove(modifiedStr);
                        }
                    }
                    arr[j] = original;
                }
                
            }
            words++;
        }

        return 0;
        
    }
}
