//Insertion Sort. The input is taken from a file and writted to //an output file.



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Isort {
	/*=========================================================================
	 *                    Class Variables
	 *=========================================================================     
	 * text = to open the file for reading
	 * 
	 * arrayOfFloats = To get the input from file in array form and later store                
	 * the sorted array. It is of static type so that it can be accessed 
	 * and updated easily.
	 * 
	 * scnr = to scan the file for data 
	 *========================================================================= 
	 */
	File text;
	static ArrayList<Float> arrayOfFloats=new ArrayList<Float>();
	Scanner scnr;
	
	

	/*========================================================================= 
	 *                    Method: openFile
	 *=========================================================================     
	 * This method is simply used to open the file after taking the filename
	 * from the command line.
	 * Otherwise, it displays a error message
	 *========================================================================= 
	 */
    void openFile(String fileName)
    {
    	Scanner scanner = new Scanner(fileName);
    	System.out.flush();
    	String filename = scanner.nextLine();
    	text = new File(filename);
    	
    	
    	scanner.close();
    	
    	if(!text.exists())
    	{
    		System.out.println("Sorry the file does not exists");
    		System.exit(0);
    	}
    	
    	
    }
    

    /*========================================================================= 
	 *                    Method: scanFile
	 *=========================================================================     
	 * This method scans the file and removes the semicolon and spaces 
	 * between the input text. It stores the unsorted data in arrayOfFloats.
	 * It also creates an empty file if the input file is empty. In 
	 * that case the program ends from this method only.
	 *========================================================================= 
	 */
void scanFile()
{   
	boolean flag=false;
try {
	
	scnr = new Scanner(text);

} 

catch (FileNotFoundException e) {
	
	e.printStackTrace();
}
      /*=========================================================================
       *  Delimiter removes the semicolon and spaces from the input text
   	 *========================================================================= 
   	 */
       scnr.useDelimiter("\\s*;\\s*|\\n");
       
       while(scnr.hasNext()){
    	   
    	   flag=true;
    	 /*=========================================================================
    	 *  Converts the input files data into a float array(list)
   		 *========================================================================= 
   		 */
        	arrayOfFloats.add(Float.parseFloat(scnr.next()));
       }
 
       scnr.close();
       
       if(flag==false)
       {
    	  
    	   try {
			PrintWriter emptyFile = new PrintWriter("answers.txt", "UTF-8");
			emptyFile.close();
		} 
    	   
    	   catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
    	   System.out.println("Empty file is created");
    	   System.exit(0);
  
       }
}

	
	/*=========================================================================
	 *                    Method: Sort
	 *=========================================================================     
	 * To Sort the Array after the file has been scanned via the scanFile 
	 * method. It returns the array list which has the sorted data of the 
	 * input text file. 
	 *========================================================================= 
	 */
	 ArrayList<Float> sort(ArrayList<Float> numbers) {
	 
	 for (int i = 1; i < numbers.size(); i++) {
         for(int j = i ; j > 0 ; j--){
             if(numbers.get(j) < numbers.get(j-1)){
                Collections.swap(numbers, j, j-1);
             }
         }
	 }
	 
		
		/*=========================================================================
		 *  Up till now, arrayOfFloats contained the unsorted input data
		 *  But the assignment below assigns sorted data to arrayOfFloats.         
		 *========================================================================= 
		 */	
		arrayOfFloats=numbers;	
		
		/*=========================================================================
		 *  Returns the sorted array       
		 *========================================================================= 
		 */	
		
        return arrayOfFloats;
	
}
    /*========================================================================= 
	 *                    Method: writeFile
	 *=========================================================================     
	 * The method is used to write the file in the answers.txt file by 
	 * manipulating it.
	 *========================================================================= 
	 */
	void writeFile(ArrayList<Float> wNumbers)
	 {
	
		StringBuilder a = new StringBuilder();
		for(int i=0;i<wNumbers.size();i++)
		{
			a.append(wNumbers.get(i).toString()+"; ");
				
		}
		
		 File outFile = new File ("answers.txt");
		 
		 FileWriter fWriter = null;
			try {
				
				fWriter = new FileWriter (outFile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		    PrintWriter pWriter = new PrintWriter (fWriter);
		   
		    pWriter.println ((a.substring(0, a.length()-2)));
		    pWriter.close();
		    
		    if(!pWriter.checkError())
		    {
		    	System.out.println("The data has been written to the file, thank you");
		    }
		    
	 }
	public static void main(String[] args) throws FileNotFoundException {
		
		 Isort ssort = new Isort(); //class object
		
		   if(args.length > 0) {
	            
			   ssort.openFile(args[0]); //args[0] contains the input file name
	
	        }
		   

       ssort.scanFile(); //to read the input file 
       ssort.sort(arrayOfFloats); //to sort the input
       ssort.writeFile(arrayOfFloats); //to write the input
       


}

	 
}