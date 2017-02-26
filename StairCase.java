// Stair Case problem: A child can climb one, two or three steps at a time. Find the possible ways
//he can climb n stairs, given that he can't come back. Given are three solutions:

public class StairCase {
	
	
	 static int countWaysUtil(int n, int m)
	    {
	        if (n <= 1)
	            return n;
	        int res = 0;
	        for (int i = 1; i<=m && i<=n; i++)
	            res += countWaysUtil(n-i, m);
	        return res;
	    }
	  
	    // Returns number of ways to reach s'th stair
	    static int countWays(int s, int m)
	    {
	        return countWaysUtil(s+1, m);
	    }
	    
	    
	public static int waysOfClimbing(int n) {
	    int[] store = new int[n+1];
	    store[0] = store[1] = 1;
	    store[2] = 2;
	    for (int i = 3; i <= n; i++) {
	        store[i] = store[i-1] + store[i-2] + store[i-3];
	    }
	    return store[n];
	}


	public static int possibleWays(int n) {
		if (n < 1) {
			return 0;
		}
		return 1 + possibleWays(n - 1) + possibleWays(n - 2)
				+ possibleWays(n - 3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(possibleWays(10));
		System.out.println(waysOfClimbing(10));
		System.out.println(countWays(10, 3));
		//System.out.println(countSteps(10));
	}

}

