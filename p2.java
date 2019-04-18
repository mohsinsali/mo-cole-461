import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.*;

public class p2
{ 
    public static void main(String[] args) throws IOException  
    { 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String input = reader.readLine();
		// String[] parsed = input.split("\\s");
    	// // for (int i = 0; i < parsed.length; i++) {
		// // 	System.out.println(parsed[i]);
		// // }
		// List<String> parsedList = Arrays.asList(parsed);
		// System.out.println(parsedList);

		while(input!=null)
		{
		System.out.println("The input is: "+input);  
		input = reader.readLine();
		}
	} 

	public static void build_expression_tree(String input){
		String[] parsed = input.split("\\s");
    	// for (int i = 0; i < parsed.length; i++) {
		// 	System.out.println(parsed[i]);
		// }
		System.out.println(parsed);
	}
} 

