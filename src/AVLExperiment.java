import java.util.*;
import java.io.*;



public class AVLExperiment {
	static String[] arrCountry = new String[9919]; 
	static String[] arrDate = new String[9919];
	static String[] arrnoOfVaccines = new String[9919];
   public static void main(String[] args) throws IOException {
	   Scanner file = new Scanner(new File("C:/UCT/Assignment 2/vaccinacions.cvs"));
	   
	   file.nextLine();
	   
	   
	   while(file.hasNextLine()) {
		   String line[] = file.nextLine().split(",",-1);
		   
		   arrCountry
		   
	   }
	   
   }
}
