public class Palindrome {
    
    public static void main(String[] args) {
        
        String s = "palindrome";
        
        char[] c = s.toCharArray();
        boolean flag = true;
        int i = 0;
        int l = c.length-1;
        
        while(i<l)
        {
            if(c[i]!=c[l])
            {
                flag = false;
            }
            
            
            i++;
            l--;
        }
            if(flag)
            {
                 System.out.println("Yes");    
            }
            
            else
            {
                System.out.println("No");
            }
 
    }
    
}
