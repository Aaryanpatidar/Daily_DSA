import java.util.Stack;

class Solution {
    public int evalRPN(String[] arr) {
        
        Stack<Integer> stk = new Stack<>();
        for(int i =0; i<arr.length; i++){
            if(arr[i].equals("+")){
                int b = stk.pop();
                int a = stk.pop();
                int c = b+a;
                stk.push(c);
            }else if(arr[i].equals("-")){
                int b = stk.pop();
                int a = stk.pop();
                int c = a-b;
                stk.push(c);
            }else if(arr[i].equals("*")){
                int b = stk.pop();
                int a = stk.pop();
                int c = b*a;
                stk.push(c);
            }else if(arr[i].equals("/")){
                int b = stk.pop();
                int a = stk.pop();
                int c = a/b;
                stk.push(c);
            }else{
                int num = Integer.parseInt(arr[i]);
                stk.push(num);
            }
            
        }
        return stk.peek();
    }
}