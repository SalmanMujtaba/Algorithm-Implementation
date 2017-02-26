//To change a string to alternate case
public class AlternateCase {

	public static void main(String[] args) {
		String x = "hello are you";
		char [] x1 = x.toCharArray();
		//	String x = jTextField1.getText();
		for (int i = 0, len = x1.length; i < len; i++) {
		    char ch = x1[i];
		    if (i % 2 == 0) {
		       
		    	x1[i]=Character.toLowerCase(x1[i]);
		    	//System.out.print(Character.toLowerCase(ch));
		    } else {
		        //System.out.print(Character.toUpperCase(ch));
		    	x1[i]=Character.toUpperCase(x1[i]);
		    }
		}
		String s = String.valueOf(x1);
		System.out.println(s);
		char[] t ={'a'};
		

	}

}
