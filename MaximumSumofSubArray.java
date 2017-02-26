//To find the maximum sum of the sub arrays

public class MaximumSumofSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A={1,-5,-6,-3,9,10,-10};
		 int newsum=A[0];
	       int max=A[0];
	       for(int i=1;i<A.length;i++){
	           newsum=Math.max(newsum+A[i],A[i]);
	           max= Math.max(max, newsum);
	       }
System.out.println(max);	

	}
	

}
