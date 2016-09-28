import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {
    
     public static boolean isBalanced(String expression) {
         Stack<Character> stack = new Stack<Character>();
         int len = expression.length();
         
         if (len > 1000 || (len % 2 != 0)) return false;
         
         for(int i = 0; i < len; ++i) {
            char c = expression.charAt(i);
             
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);     
            } else {
                
                if (stack.isEmpty()) return false;
                
                Character peek = stack.peek();
                
                if ((c == ')' && peek == '(') || (c == '}' && peek == '{') || (c == ']' && peek == '[')) {
                    stack.pop();
                } else {
                    return false;   
                }
            }
        }
         
        if (stack.isEmpty())
            return true;
         
        return false;
     }
  
   public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
             boolean answer = isBalanced(expression);
             if(answer)
              System.out.println("YES");
             else System.out.println("NO");
        }
        */
        
        String inputs[] = {"{[()]", "{{{{", "}}}}", "", "{}", "{[(])}", "{{[[(())]]}}"};
        
        for (String input : inputs) {
            System.out.println(input + " => " + isBalanced(input));
        }
        
    }
}

