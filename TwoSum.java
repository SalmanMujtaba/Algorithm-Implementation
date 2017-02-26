//To find two numbers in an array whose sum is equal to target = 11

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	 
	   
	    Map map = new HashMap();
	    
	  
	    
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = (int) map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  
		
		
		
		TwoSum a = new TwoSum();
		int[] num= {4,6,7,1};
		
		int[] res = a.twoSum(num,11);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}

}
