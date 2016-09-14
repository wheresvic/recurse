import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer, Integer> ref = new HashMap<Integer, Integer>();
        
        int[] answer = new int[2];
        
        for (int i = 0; i < numbers.length; ++i) {
            
            int diff = target - numbers[i];
            
            if (ref.containsKey(diff)) {
                answer[0] = ref.get(diff) + 1;
                answer[1] = i + 1;
                return answer;
            }
            
            ref.put(numbers[i], i);
            
        }
        
        return answer;
    }
    
    public static void main(String args[]) {
    	TwoSum instance = new TwoSum();
    	
    	int input[] = new int[]{2, 7, 11, 15};
    	int target = 9;
    	
    	int result[] = instance.twoSum(input, target);
    	
    	for (int i = 0; i < input.length; ++i) {
    		System.out.print(input[i] + " ");
    	}
    	
    	System.out.print(", " + target + " => ");
    	
 		System.out.println(result[0] + " " + result[1]);   	
    }
}
