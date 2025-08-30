import java.util.*;

class ValidSudoku {
     public static boolean isValidSudoku(char[][] board) {
        Set<String> s = new HashSet<>();
        for(int i =0; i<9; i++){
            for(int j =0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                String r = board[i][j]+'R'+String.valueOf(i);
                String c = board[i][j]+'C'+String.valueOf(j);
                String b = board[i][j]+'B'+String.valueOf(i/3) + String.valueOf(j/3);
                if(s.contains(r) || s.contains(c) || s.contains(b)){
                    return false;
                }
                s.add(r);s.add(c);s.add(b);
            }
        }
        return true;
    }

    public static void main(String [] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        boolean isValid = isValidSudoku(board);
        System.out.println("Given board is valid sudoku : "+isValid);
    }
}