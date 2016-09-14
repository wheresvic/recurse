import java.util.Stack;	

public class ValidParens {

    public boolean isValidParens(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        
        int N = s.length();
        
        for (int i = 0; i < N; ++i) {
            
            char c = s.charAt(i);
            
            if (c == '}' || c == ')' || c == ']')
            {
                if (!stack.isEmpty()) {
                    
                    char p = stack.pop();
                    
                    if (c == '}' && p != '{') {
                        return false;
                    }
                    
                    if (c == ')' && p != '(') {
                        return false;
                    }
                    
                    if (c == ']' && p != '[') {
                        return false;
                    }
                }
                else 
                {
                    return false;
                }
            }
            else 
            {
                stack.push(c);    
            }

        }
        
        if (stack.isEmpty())
            return true;
            
        return false;
    }
    
    public static void main(String args[]) {
    
    	ValidParens instance = new ValidParens();
    
    	String a = "[]{}()";
 		String b = "";
    
    	System.out.println(a + "\t" + instance.isValidParens(a));
    	System.out.println(b + "\t" + instance.isValidParens(b));
    }
}
