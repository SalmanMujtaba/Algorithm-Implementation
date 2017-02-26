//To find the LCS of 2 strings
import java.io.File;
import java.util.Scanner;

public class LCS {

	
	String a,b;
	char[] X;
	char[] Y;
	LCS()
	{
		
	

		a="abcde";
		b="abbcd";
		 X = a.toCharArray();
		 Y = b.toCharArray();
		
	}
	void LCS_Length()
	{
		
		int m = X.length;
		int n = Y.length;
	    int[][] c = new int[m+1][n+1];
		
		//System.out.println(m+"     "+n);
		
		
		 for (int i=0; i<=m; i++)
		   {
		     for (int j=0; j<=n; j++)
		     {
		       if (i == 0 || j == 0)
		         c[i][j] = 0;
		  
		       else if (X[i-1] == Y[j-1])
		         c[i][j] = c[i-1][j-1] + 1;
		  
		       else
		         c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
		     }
		   }
		 
		
		    
		    
		
		 int index = c[m][n];
		
		 char[] LCS = new char[index];
		 
	
		  int i = m, j = n;
		   while (i > 0 && j > 0)
		   {
		     
		      if (X[i-1] == Y[j-1])
		      {
		
		          LCS[index-1] = X[i-1]; 
		          i--; j--; index--;     
		      }
		 
		   
		      else if (c[i-1][j] > c[i][j-1])
		         i--;
		      else
		         j--;
		   }
		 
		 //  System.out.println("I am here");
		   System.out.println(LCS);
		   

	}
	
	
	private void memoizedLCS(char[] x2, char[] y2, int m, int n) {
		// TODO Auto-generated method stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		LCS a=new LCS();
	a.LCS_Length();
		
	}

}
