import java.util.*;

class Spreadsheet {

    HashMap<Character,int []> map;
    public Spreadsheet(int rows) {
        map = new HashMap<>();
        for(int i =0 ;i<26;i++) {
            char c = (char)('A'+i);
            map.put(c,new int[rows]);
        }
    }
    
    public void setCell(String cell, int value) {
        char c = cell.charAt(0);
        String r = cell.substring(1,cell.length());
        int row = Integer.parseInt(r) -1; 
        int arr []= map.get(c);
        arr[row] = value;
    }
    
    public void resetCell(String cell) {
        char c = cell.charAt(0);
        String r = cell.substring(1,cell.length());
        int row = Integer.parseInt(r) -1; 
        int arr []= map.get(c);
        arr[row] = 0;
    }
    
    public int getValue(String s) {
        int eqIndex = s.indexOf('=');  
        int plusIndex = s.indexOf('+');
        int a =0,b=0; 
        char c1 =s.charAt(eqIndex+1);
        char c2 =s.charAt(plusIndex+1);
        if (c1>='0' && c1<='9') {
            String r = s.substring(eqIndex+1,plusIndex);
            a = Integer.parseInt(r);
        } else {
            char c = s.charAt(eqIndex+1);
            String r = s.substring(eqIndex+2,plusIndex);
            int row = Integer.parseInt(r) -1;
            int arr []= map.get(c);
            a = arr[row];
           }
        if (c2>='0' && c2<='9') {
            String r = s.substring(plusIndex+1,s.length());
            b = Integer.parseInt(r);
        } else {
            char c = s.charAt(plusIndex+1);
            String r = s.substring(plusIndex+2,s.length());
            int row = Integer.parseInt(r) -1;
            int arr []= map.get(c);
            b = arr[row];
        }
        System.out.println(b);
        return a+b;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */