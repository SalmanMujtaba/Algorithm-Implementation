/* To print 
 *    #
 *   ##
 *  ###
 * ####
 *#####
 *
 * and a triangle of stars
 */
public class ToPrintPattern {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	int n = 5;
	    for(int i=1;i<=n;i++)
        {
	    	
        for(int j=n;j>i;j--)
            {
        	
        	System.out.print(" ");
      }
        int k=0;
        while(k!=i)
        {
        System.out.print("#");
        k++;
	   
    }
        System.out.println();
	  
        }
	    
	    for (int i = 0; i < 5; i++) 
	    	  System.out.println("    *********".substring(i, 5 + 2*i));


	}
}
