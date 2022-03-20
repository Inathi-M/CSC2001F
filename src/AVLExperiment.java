import java.util.*;
import java.io.*;



public class AVLExperiment {
	static String[] arrCountry = new String[9919]; 
	static String[] arrDate = new String[9919];
	static String[] arrnoOfVaccines = new String[9919];
   public static void main(String[] args) throws IOException {
	   
	   Scanner file = new Scanner(new File("C:/UCT/Assignment 2/vaccinations.csv"));
	   
	   file.nextLine();
	   
	   int counter = 0;
	   while(file.hasNextLine()) {
		   String line[] = file.nextLine().split(",",-1);
		   
		   String country = line[0];
		   String date = line[1];
		   String noOfVaccine = line[2];
		   
		   
		   arrCountry[counter] = country;
		   arrDate[counter] = date;
		   arrnoOfVaccines[counter] = noOfVaccine;
		   
		   
		  
		   counter++;
	   }
	   
	   for (int a = 0;a < 9919;a++)
	   {
		   
		   System.out.println(arrCountry[a]);
	   }
	   
	   
	   
   }
}
