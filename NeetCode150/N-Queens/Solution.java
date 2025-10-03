import java.util.*;

class Solution {
    Set<Integer>c;
    Set<Integer>d1;
    Set<Integer>d2;
    List<List<String>> ans;
    char[][] board;

    public boolean isValid(int row, int col){
        return !(c.contains(col) || d1.contains(row+col) || d2.contains(row-col));
    }

    public void rec(int n, int row ){
        if(row>=n){
            List<String> temp = new ArrayList<>();
            for(int i =0; i<n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int col =0; col< n; col++){
            if(isValid(row,col)){
                board[row][col] = 'Q';
                c.add(col); d1.add(row+col); d2.add(row-col);
                rec(n,row+1);
                c.remove(col); d1.remove(row+col); d2.remove(row-col);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        c = new HashSet<>();
        d1 = new HashSet<>();
        d2 = new HashSet<>();
        ans = new ArrayList<>();
        board = new char[n][n];

        for(int i =0 ;i<n; i++){
            Arrays.fill(board[i], '.');
        }

        rec(n,0);
        return ans;
    }
}