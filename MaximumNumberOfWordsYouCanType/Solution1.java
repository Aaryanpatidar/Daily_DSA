import java.util.HashSet;

class Solution1 {
    public static int canBeTypedWords(String t, String bl) {
            HashSet<Character> set = new HashSet<>();
            for(int i= 0; i<bl.length();i++){
                set.add(bl.charAt(i));
            }  
            
             int i= 0,ans=0;
                boolean is=true;
            while(i<t.length()){
                if(t.charAt(i)==' '){
                if(is){ans++;}
                else{is=true;} 
                    
                }else if(set.contains(t.charAt(i))){
                is=false;    
                }
            i++;  
            } 
                if(is){ans++;}
                else{is=true;}

                return ans;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        String t = "el";
        int ans = canBeTypedWords(s, t);
        System.out.println(ans);
    }
}