
public class ReverseDigits {

    public int reverse(int x) {
        
        int neg = 1;
        
        if (x < 0)
            neg = -1;
            
        x = Math.abs(x);
        
        int num = 0;
        
        while (x > 0) {
            
            if (((long)num * 10) + (x%10) > Integer.MAX_VALUE)
                return 0;
            
            num = (num * 10) + (x%10);
            x = x/10;
            
        }
        
        return neg * num;
    }
    
    public static void main(String args[]) {
    	
    	ReverseDigits instance = new ReverseDigits();
    	
    	int number = 123456789;
    	System.out.println(number);
    	System.out.println(instance.reverse(number));	
    	
    }
}
