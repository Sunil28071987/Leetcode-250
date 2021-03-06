class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        for(String word: words){
            if(exist(board,word))
                set.add(word);
        }
        result.addAll(set);
        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        int tracker [][] = new int [board.length][board[0].length];
        for(int row=0; row<board.length;row++)
            for(int col=0; col<board[row].length;col++){
                if(board[row][col]==word.charAt(0)){
                    if(isWord(board,word,0,row,col,tracker))
                        return true;
                }
            }
        return false;
    }
    
    public boolean isWord(char[][] board, String word, int index, int row, int col, int [][] tracker){
        if(index==word.length())
            return true;
        if(row<0 || row>=board.length || col<0 || col>=board[row].length)
            return false;
        
        if(tracker[row][col]==-1)
            return false;
        
        if(word.charAt(index)==board[row][col]){
             tracker[row][col]=-1;
            
            for(int i = -1; i <=1; i++)
            {  for(int j = -1; j<=1; j++)
                {
                    if(Math.abs(i)+Math.abs(j) != 1)
                        continue;
                
                    if(isWord(board,word,index+1,row+i,col+j,tracker))
                        return true;
                } 
            }  
           tracker[row][col] =0;
        }
        
        return false;
    }
}


=================================================Solution 2===========================================================
    
    
