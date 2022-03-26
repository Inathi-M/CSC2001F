import java.util.*;
import java.io.*;


/**
 * 
 * @author      		Nkosinathi Tshaphile
 * Student Number : 	TSHNKO012
 * GitUsername :		Inathi-M
 *
 */
public class AVLExperiment {
	
	public static List<PrintWriter> writers = new ArrayList<PrintWriter>();
	public static AVLTree avl = new AVLTree ();
	static String[] arrCountry = new String[9919]; 
	static String[] arrDate = new String[9919];
	static String[] arrnoOfVaccines = new String[9919];
	public static BinaryTree btree = new BinaryTree();
	public static AVLTree first_avl = new AVLTree();
	public static AVLTree<String> second_avl = new AVLTree<String>();
	public static AVLTree<String> aCountry;
	public static AVLTree<String>  avl_tree;
	public static int bestcase,worstcase;
	public static String[] arrAVL = new String[9919];
	private static Scanner keyboard;
	
	
	 /**
	  * This method is used to find the insertion and search operations, 
	  * it searches for countries for a certain vaccination date and prints out a string mentioning both the insert, search and the country for each country
	  * in the specified day
	  * @param place for the country
	  * @param day for the date
	  * @param rootNode
	  * @param SampleSize for the number of sample data
	  * @return	result
	  * @throws NullPointerException
	  */
	      public static String printOperations(String place, String day,BinaryTreeNode<String> rootNode,int SampleSize) throws NullPointerException{
	      int averagecase = 0;
	      String result = "";
	      BinaryTreeNode<String> BTN = aCountry.find(place,rootNode);
	      if (BTN == null){
	            result = place + " = <Not Found>";
	      }
	      
	      boolean check = false;
	      try{
	      String data = BTN.getData();
	      
	      for(int a = 0;a < SampleSize -1 ;a++){
	         if((arrCountry[a] + arrDate[a]).equals(data + day)){
	             check = true;
	             result = ("There are  "+aCountry.SearchOperation() + " search operations for "+ arrCountry[a]+ " ,and " + aCountry.InsertOperation() + " insert operations.");
	         }
	         
	      }
	      
	      if(check == false){
	         result = (place + " = <Not Found>");
	      }
	      return result;
	      
	      }catch(Exception e){
	            return result;
	      }
	   }
	      
	      /**
	       * This method is used to randomize the data, it swaps the elements in the Country array about in a random manner,
	       * using the method Random as a way to randomize the the values in the data set.
	       * @param arrayCountry for the values of countries in the dataset 
	       * @param subset 
	       * @param sDate date that will be used to randomize data in the data set 
	       * @param sampledata is the Print Writer where 
	       * @return result
	       * @throws NullPointerException
	       */
	      	      
	   public static String randomizeData(String[] arrayCountry, int subset, String sDate, PrintWriter sampledata) throws NullPointerException{
		   String result = "";
	       int opCount = 0;
	       int average = 0;   
	       int smallest = aCountry.SearchOperation();
	       int biggest = aCountry.SearchOperation();
		   Random randNumber = new Random();
		   int max_no = subset;
		   int min_no =1;
		   for(int x = 0;x < subset -1;x++) {
			   int rand_subset = min_no + randNumber.nextInt(max_no);
			   int l = rand_subset;
			   
			   if(l+x > 9915) {
				   continue;
			   }else {
				   System.out.println(l+x);
				  // System.out.println(arrCountry[x+l]);
				   System.out.println(printOperations(arrCountry[l+x],sDate,aCountry.root,subset));
				   sampledata.println(printOperations(arrCountry[l+x],sDate,aCountry.root,subset));
				   
				   
		              opCount = opCount + aCountry.SearchOperation();
		              if (smallest > aCountry.SearchOperation()){
		                  smallest = aCountry.SearchOperation();
		              } //end of if
		              if(biggest < aCountry.SearchOperation()){
		                  biggest = aCountry.SearchOperation();
		              }
						 }
		            } 
		             
		             average  = (opCount / subset);
                     
		             System.out.println("The average value is " + average +"|The maximum value is "+biggest + "|And the minimum value is "+ smallest) ; 
		             
		             sampledata.println("The average value is " + average +"|The maximum value is "+biggest + "|And the minimum value is "+ smallest);

		   return result;
		   
	   }
	   
	   /**
	    * This method is used to create a maximum of 20 different textfiles named from Randomizedfile1.txt to Randomizedfile20.txt 
	    * It uses a for loop to create a maximum of 20 different PrintWriters
	    * @param ram_no
	    * @param sDate
	    * @throws IOException
	    */
	    public static void createFiles(String ram_no,String sDate) throws IOException{
	    	
	     int randomization_no =Integer.parseInt(ram_no); 
	     List<PrintWriter> writers = new ArrayList<PrintWriter>();

	     for (int i = 0; i <= randomization_no; i++) {
	         PrintWriter randomized_file = new PrintWriter("/mnt/c/UCT/Assignment 2/RandomizedData/Randomizedfile" + i + ".txt", "UTF-8");
	         writers.add(randomized_file);
	         randomizeData(arrCountry,9919,sDate,randomized_file);
	     }

	     for (PrintWriter randomized_file : writers) {
	         randomized_file.close();
	     }  
	  }
	    
 /**
  * This is the main method where everything is initiated, the Scanner and File class are used to read in the data set
  * It also loads the data in the country array
  * it then populates the AVL tree.
  * @param args
  * @throws IOException
  */

	
   public static void main(String[] args) throws IOException {
	   //int search =0;
	   keyboard = new  Scanner(System.in);
	   aCountry = new AVLTree<String>();
	   String sDate;
	   
	   Scanner file = new Scanner(new File("/mnt/c/UCT/Assignment 2/vaccinations.csv"));
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
		   String allData = country +" "+date +" "+noOfVaccine;
		   
		   aCountry.insert(country);
		   second_avl.insert(allData);
		   counter++;
	   }

       System.out.println("Enter the date: ");
       sDate = keyboard.nextLine();
	   
       createFiles(args[0],sDate);
   }
}
