import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Integer> [] col = new Set[9];
        Set<Integer> [] row = new Set[9];
        Set<Integer> [] box = new Set[9];

        for (int i = 0; i < 9; i++) {
            col[i] = new HashSet<>();
            row[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        
        for(int i =0; i<9; i++){
            for(int j =0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int a = board[i][j] - '0';
                int b = (3*(i/3)) + (j/3);
                if(col[j].contains(a) || row[i].contains(a) || box[b].contains(a)) {
                    return false;
                }
                col[j].add(a); row[i].add(a); box[b].add(a);
            }    
        }
        return true;
        // Set<String> s = new HashSet<>();
        // for(int i =0; i<9; i++){
        //     for(int j =0;j<9;j++){
        //         if(board[i][j]=='.'){
        //             continue;
        //         }
        //         String r = board[i][j]+'R'+String.valueOf(i);
        //         String c = board[i][j]+'C'+String.valueOf(j);
        //         String b = board[i][j]+'B'+String.valueOf(i/3) + String.valueOf(j/3);
        //         if(s.contains(r) || s.contains(c) || s.contains(b)){
        //             return false;
        //         }
        //         s.add(r);s.add(c);s.add(b);
        //     }
        // }
        // return true;
    }
}