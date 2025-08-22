class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Set<Character>> hashR = new HashMap<>();
        HashMap<Integer,Set<Character>> hashC = new HashMap<>();
        HashMap<Integer,Set<Character>> hashB = new HashMap<>();

        for(int i=0;i<9;i++){
            hashR.put(i,new HashSet<>());
            hashC.put(i,new HashSet<>());
            hashB.put(i,new HashSet<>());
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    char ch = board[i][j];

                    int index = (i / 3) * 3 + (j / 3);

                    Set<Character> st1 = hashR.get(i);
                    Set<Character> st2 = hashC.get(j);
                    Set<Character> st3 = hashB.get(index);
                    if(st1.contains(ch) || st2.contains(ch) || st3.contains(ch)){
                        return false;
                    }

                    st1.add(ch);
                    st2.add(ch);
                    st3.add(ch);

                    hashR.put(i,st1);
                    hashC.put(j,st2);
                    hashB.put(index,st3);
                }
            }
        }

        return true;
    }
}