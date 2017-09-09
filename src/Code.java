
/**
 * Class Code contains the methods used to translate a sentence to Morse Code
 * 
 * ITCS-3112
 * @author Taylor Smith
 * @version July 13th 2016
 */
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


public class Code
{	
	// Creates new ArrayList string for the Morse Key
	ArrayList<String> morseKey = new ArrayList<String>(); 
	
	// Pre-translated message
	String translateMessage; 
	
	// Holds message translated to morse code
	String morseMessage; 
	
	/**
	 * Code() - Default constructor for class code. Sets translateMessage and morseMessage to ""
	 * 
	 */
	public Code()
	{
		 
		 translateMessage = "";
		 morseMessage = "";
	}
	
	
	/**
	 * openFileToArray - Method opens the "Morse.txt" text file and adds the data to an ArrayList
	 * 
	 */
	public void openFileToArray() throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(new File("Morse.txt"));
	    
	    //Adds to array while there is data
	    while(inputFile.hasNext())
	    {
	    	morseKey.add(inputFile.nextLine());
	    }
	    inputFile.close();
	}
	
	
	/**
	 * messageToBeTranslated - Method uses JOptionPane to prompt user to enter message to be translated to Morse code.
	 * Sets the message to upper case so it can be compare to the first character in the ArrayList
	 */
	public void messageToBeTranslated()
	{
		translateMessage = JOptionPane.showInputDialog("Enter message to be translated to morse code:");
	    translateMessage = translateMessage.toUpperCase();
	}
	
	
	/**
	 * translateMessage - Method translates the user message into morse code.
	 * First loops through the ArrayList comparing the first character to the corresponding character in the user message. 
	 * Once it is found, the ArrayList index is split where there is a space and added to a 
	 * new string representing the translated message.
	 * If the user message contains a space, three spaces are added to the new string. 
	 */
	public void translateMessage()
	{
		morseMessage = ""; // Translated Message set to nothing. 
	    
		// Loops through user message
	    for(int i = 0; i < translateMessage.length(); i++)
	    {
	    	// Adds 3 spaces to represent a new word
	    	if(translateMessage.charAt(i) == ' ')
	    	{
	    		morseMessage += "   ";
	    	}
	    	
	    	// Loops through ArrayList 
	    	for(int j = 0; j < morseKey.size(); j++)
	    	{	
	    		// Adds second part of ArrayList to new string if there is a match
	    		if(morseKey.get(j).charAt(0) == translateMessage.charAt(i))
	    		{
	    			morseMessage += morseKey.get(j).substring(morseKey.get(j).indexOf(" ")) + " ";
	    		}
	    	}
	    }
	}
	
	
	/**
	 * printTranslatedMessage - Method uses JOptionPane to print both the original and translated messages.
	 */
	public void printTranslatedMessage()
	{
		JOptionPane.showMessageDialog (null, translateMessage + ": \n" + morseMessage, "Message in Morse Code: ", JOptionPane.PLAIN_MESSAGE);
	}
	
	
	/**
	 * continueMessage - Method uses JOptionPane to determine if user wants to translate another message. 
	 * @return int - 1 or 0 to be used to determine if user wants to translate another message
	 */
	public int continueMessage()
	{
		int cont = 0;
		cont = JOptionPane.showConfirmDialog(null,"Do you want to enter another message?");
	    
		return cont;
	}
	
	
    
}
