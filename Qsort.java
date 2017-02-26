//Quick Sort after taking inoput from a semi colon separated file 


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Qsort {
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
	 * partitionIndex = to get the pivot element from the array/subarray 
	 * so the the left elements are smaller than the pivot, and the right 
	 * elements are larger than pivot.
	 * 
	 * inputFileName = to get the input file name
	 *========================================================================= 
	 */
	File text;
	static ArrayList<Float> arrayOfFloats=new ArrayList<Float>();
	Scanner scnr;
	int partitionIndex;
	String inputFileName;
	
	


	/*========================================================================= 
	 *                    Method: openFile
	 *=========================================================================     
	 * This method is simply used to open the file after taking the filename
	 * from the command line.
	 * Otherwise, it displays a error message
	 *========================================================================= 
	 */
    void openFile()
    {
    	Scanner scanner = new Scanner(inputFileName);
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
			PrintWriter emptyFile = new PrintWriter("answer.txt", "UTF-8");
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
     	 *                    Method: getStartIndex
     	 *=========================================================================     
     	 * This method is used to fetch the start index of the list
     	 *========================================================================= 
     	 */	  
     	int getStartIndex()
     	{
     		return 0;
     	}
     	
     	/*========================================================================= 
     	 *                    Method: getEndIndex
     	 *=========================================================================     
     	 * This method is used to fetch the last index of the list
     	 *========================================================================= 
     	 */	
     	int getEndIndex()
     	{
     		return (arrayOfFloats.size()-1);
     	}
     	

	
	/*=========================================================================
	 *                    Method: quickSort
	 *=========================================================================     
	 * To Sort the Array after the file has been scanned via the scanFile 
	 * method. It returns the array list which has the sorted data of the 
	 * input text file. 
	 *========================================================================= 
	 */
        void quickSort(ArrayList<Float>A,int start,int end)
          {
	
	         if(start<end)
	         {

		       partitionIndex=partition(A, start, end);
		       quickSort(A, start, partitionIndex-1);
		       quickSort(A, partitionIndex+1,end);
	         }
	arrayOfFloats=A;
	
          }
        
    	/*========================================================================= 
    	 *                    Method: partition
    	 *=========================================================================     
    	 * This method is used to get the pivot element from the list.
    	 * It is called from quickSort multiple times.
    	 *========================================================================= 
    	 */	
    	int partition(ArrayList<Float>A,int start,int end)
    	{
    		float pivot = A.get(end);
    	    partitionIndex = start;
    		int i = start;  
    		while(i<end)
    		  {
    			  
    			if (A.get(i)<=pivot)
    			{
    				Collections.swap(A, i, partitionIndex);
    				partitionIndex+=1;
    			
    			
    			}
    			i++;
    			
    		  }
    		Collections.swap(A,partitionIndex , end);
    		return partitionIndex;
    	}
	

	
	

    /*========================================================================= 
	 *                    Method: writeFile
	 *=========================================================================     
	 * The method is used to write the file in the answer.txt file by 
	 * manipulating it. The data is appended to the file.
	 *========================================================================= 
	 */
	void writeFile(ArrayList<Float> wNumbers, long time)
	 {
	
		StringBuilder a = new StringBuilder();
		for(int i=0;i<wNumbers.size();i++)
		{
			a.append(wNumbers.get(i).toString()+"; ");
				
		}
		 
		 
		 File outFile = new File ("answer.txt");
		 
		
		 
		 FileWriter fWriter = null;
			try {
				
				fWriter = new FileWriter (outFile,true);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		    PrintWriter pWriter = new PrintWriter (fWriter);

		    pWriter.println("Sorting Result");
		    pWriter.println (inputFileName+" sorted: "+ (a.substring(0, a.length()-2)));
		    pWriter.println("Performance Analysis");
		    pWriter.println("Input File       Size      Sorting Time(in milliseconds)");
		    pWriter.println(inputFileName+"       "+wNumbers.size()+"          "+time);
		    pWriter.println("\n");	  
		    if(!pWriter.checkError())
		    {
		    	System.out.println("The data has been written to the file, thank you");
		    }
		   
		    
	 }
	public static void main(String[] args) throws FileNotFoundException {
		
		 Qsort ssort = new Qsort(); //class object
		
		   if(args.length > 0) {
			   ssort.inputFileName=args[0];   
			   ssort.openFile(); //args[0] contains the input file name
	
	        }
	   
       ssort.scanFile(); //to read the input file
       
       //TO calculate Time
       
       long time1=System.currentTimeMillis();
       ssort.quickSort(arrayOfFloats,ssort.getStartIndex(),ssort.getEndIndex());
       long time2= System.currentTimeMillis();
       ssort.writeFile(arrayOfFloats, time2-time1); //to write the input
       
       


}

	 
}


/*==============================================================================
 *   Readme File
 *==============================================================================
 *   Program Design
 * 1) The program contains methods: openFile, scanFile, quickSort and 
 * writeFile and some others.
 * 2) The program is supposed to be run three times.   
 *==============================================================================
 *   Algorithm used
 * i) The Partition is the main part of the Algorithm
 * ii)The worst case complexity is Theta(n^2) and the average case case complexity is 
 *    Theta(nlogn)
 * iii) We recursively call quicksort to get the subarrays. A pivot is chosen 
 *      from the array such that the left elements of the pivot is lesser than the 
 *      pivot in the array. The right elements to the pivot are larger than the pivot.
 *      We merge the subarrays to get one sorted array. No auxiliary array is used like 
 *      that of Merge Sort.  
 * Partition(A,start,end)
 *1)	pivot = A[end]
 *2)	partitionIndex = start
 *3)	    i = start
 *4)	    while(i<end)
 *5)	       if(A[i] < = pivot)
 *6)	          exchange(A[i], A[partitionIndex])
 *7)	          partitionIndex+=1
 *8)	exchange(A[partitionIndex], A[end])
 *9)	return partitionIndex
 *==============================================================================
 * Compiler and Platform Used
 * Java VM
 * jGRASP version 2.0.3
 * JDK version: 1.8.0_102
 *===============================================================================
 * Limitations of the Program  
 * The program throws Stack Overflow error when the input size is significantly
 * large. (Approx. greater than 35k of records)
 *===============================================================================
 * Data Structure: Variables used 
 * text, arrayOfFloats, scnr, partitionIndex, inputFileName
 *===============================================================================
 */	 
