
/**
 * Class Morse - Driver class for the Morse Code program. 
 * 
 * @author Taylor Smith
 * @version July 13th, 2016
 * ITCS 3112-080

 */
import java.io.*;

public class Morse 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Code mc = new Code(); // Creates new Code object
	    int continueValue = 0;// Holds value to determine if user is done
	  
	    
	    mc.openFileToArray(); // Opens the "Morse.txt" file and saves it to an array
	    
	    //Loops until user wants to terminate program
	    while(continueValue != 1)
	    {
	    	mc.messageToBeTranslated(); // Prompts user for message
	    	mc.translateMessage(); // Translates to morse code
	    	mc.printTranslatedMessage(); // Prints both messages
	    	continueValue = mc.continueMessage(); // Determines if user wants to continue
	    }
	}
}
