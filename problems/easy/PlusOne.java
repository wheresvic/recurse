
public class PlusOne {
    public int[] plusOne(int[] digits) {
        
        boolean add = true;
        
        for (int i = digits.length - 1; i >= 0; --i) {
            int sum = digits[i] + 1;
            
            if (sum > 9) {
                digits[i] = sum % 10;
            } else {
                digits[i] = sum;
                add = false;
                break;
            }
        }
        
        if (add) {
            int newDigits[] = new int[digits.length + 1];
            
            newDigits[0] = 1;
            
            int j = 1;
            
            for (int i = 0; i < digits.length; ++i) {
                newDigits[j++] = digits[i];
            }
            
            return newDigits;
        }
        
        return digits;
    }
    
    private static void print(String digits, int result[]) {
    
    	System.out.print(digits + " => ");
    	
    	for (int i = 0; i < result.length; ++i) {
    		System.out.print(result[i]);
    	}
    	
    	System.out.println("");
    	
    }
    
    public static void main(String args[]) {
    	
    	PlusOne instance = new PlusOne();
    	
    	int digits[] = new int[]{9, 9, 9};	
    	
    	int result[] = instance.plusOne(digits);
    	
    	print("999", result);

    }
}

