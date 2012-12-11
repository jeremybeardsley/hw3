import java.util.*;
public class ttester {


	
	    public static void main(String args[])
	    {
	        System.out.println("To test for Tautology, enter your expression \n > means iff \n < means if then \n & means and" +
	        		"\nV means Or \n ~ means Not \n \nInput:");
	        
	        Scanner scan = new Scanner(System.in);
	        String input = scan.nextLine();
	        
	        
	        list m = new list();
	        m.postfix(input);
	        m.Evaluate(m.output);
	    }
	}