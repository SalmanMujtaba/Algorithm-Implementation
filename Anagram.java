/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coll;

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
