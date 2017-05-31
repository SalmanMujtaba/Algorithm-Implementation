/*
To find whether two strings are Anagrams
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Anagram {
    public static void main(String[] args) {
        
    
  
    String first = "abcd";
    String second = "bacd";
    
    char[] f = first.toLowerCase().toCharArray();
    char[] s = second.toLowerCase().toCharArray();
    
    Arrays.sort(f);
    Arrays.sort(s);
    
   
    boolean status = Arrays.equals(f, s);
    if(status)
    {
        System.out.println("Anagram: Yes");
    }
    else
    {
        System.out.println("Anagram: No");
    }
   
    }
}
