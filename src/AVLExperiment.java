import java.util.*;
import java.io.*;



public class AVLExperiment {
	public static List<PrintWriter> writers = new ArrayList<PrintWriter>();
	
	public static AVLTree avl = new AVLTree ();
	static String[] arrCountry = new String[9919]; 
	static String[] arrDate = new String[9919];
	static String[] arrnoOfVaccines = new String[9919];
	public static BinaryTree btree = new BinaryTree();
	public static AVLTree first_avl = new AVLTree();
	public static AVLTree second_avl = new AVLTree();
	public static AVLTree<String> aCountry;
	public static AVLTree<String>  avl_tree;
	public static int bestcase,worstcase;
	public static String[] arrAVL = new String[9919];

	private static Scanner keyboard;
	
	
	 /*
	  This method is used to determine the number of iterations it takes for the traditional array to find the given ]
	  combinations of country + date.
	  The result is the iterations for each country and the country name.s   
	*/
	      public static String printComparisons(String place, String day,BinaryTreeNode<String> rootNode,int SampleSize) throws NullPointerException{
	      int averagecase = 0;
	      String result = "";
	      BinaryTreeNode<String> BTN = aCountry.find(place,rootNode);
	      if (BTN == null){
	            result = place + " = <Not Found>";
	      }
	      
	      boolean check = false;
	      try{
	      String data = BTN.getData();
	      bestcase = aCountry.SearchOperation();
	      for(int a = 0;a < 9918;a++){
	         if((arrCountry[a] + arrDate[a]).equals(data + day)){
	             check = true;
	             result = ("There are  "+aCountry.SearchOperation() + " search operations for "+ arrCountry[a]+ " ,and " + aCountry.InsertOperation() + " insert operations.");
	             
	                  if(bestcase > aCountry.SearchOperation())
	                   bestcase = aCountry.SearchOperation(); 
	                  
	                  if(worstcase < aCountry.SearchOperation())
	                   worstcase = aCountry.SearchOperation();
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
	      
	      
	   public static String randomizeData(String[] arrayCountry, int subset, String sDate, PrintWriter sampledata) throws NullPointerException{
		   String result = "";
	       int opCount = 0;
	       int average = 0;   
	       int smallest = 0;
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
				   System.out.println(printComparisons(arrCountry[l+x],sDate,aCountry.root,subset));
				   sampledata.println(printComparisons(arrCountry[l+x],sDate,aCountry.root,subset));
				   
				   
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
                     
		             System.out.println("The average value is" + average +"|The maximum value is "+biggest + "|And the minimum value is "+ smallest) ; 
		             sampledata.println();

		   return result;
		   
	   }
	   
	   /**
	   This method is used to create 10 different textfiles named from sample1.txt to sample10.txt to store the results from
	   calculating the iterations required to find the country + date combinations for each of the 10 different subset values.
	   The method then calls the calculatesubsets method to write the results to the 10 different textfiles for the 10 different subsets
	   There is only one argument, it is the date
	 */
	    public static void createFiles(String ram_no,String sDate) throws IOException{
	    	
	     int randomization_no =Integer.parseInt(ram_no); // making this dynamic left as an excercise
	     List<PrintWriter> writers = new ArrayList<PrintWriter>();

	     for (int i = 0; i <= randomization_no; i++) {
	         PrintWriter randomized_file = new PrintWriter("C:/UCT/Assignment 2/RandomizedData/Randomizedfile" + i + ".txt", "UTF-8");
	         writers.add(randomized_file);
	         randomizeData(arrCountry,9919,sDate,randomized_file);
	     }

	     for (PrintWriter randomized_file : writers) {
	         randomized_file.close();
	     }
	     
	  }

	
   public static void main(String[] args) throws IOException {
	   //int search =0;
	   keyboard = new  Scanner(System.in);
	   aCountry = new AVLTree<String>();
	   String sDate;
	   
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
		   String allData = country +" "+date +" "+noOfVaccine;
		   
		   aCountry.insert(country);
		   second_avl.insert(allData);
		   counter++;
	   }
	   
	 /**  for(int a = 0;a< 9919;a++) {
		  System.out.println(aCountry.InsertOperation() + " operations for " + arrCountry[a] );
		   
	   }
	   */
       System.out.println("Enter the date: ");
       sDate = keyboard.nextLine();
	   
       createFiles(args[0],sDate);
   }
}
