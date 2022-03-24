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
	             result = ("There are  "+aCountry.SearchOperation() + " iterations for "+ arrCountry[a] );
	             
	                  if(bestcase > aCountry.SearchOperation())
	                   bestcase = aCountry.SearchOperation(); 
	                  
	                  if(worstcase < aCountry.SearchOperation())
	                   worstcase = aCountry.SearchOperation();
	         }
	         
	      }
	      result = result + bestcase + " " + worstcase;
	      
	      if(check == false){
	         result = (place + " = <Not Found>");
	      }
	      return result;
	      
	      }catch(Exception e){
	            return result;
	      }
	   }

	/*
	   This method is used to test the traditional array using 10 different subsets of values that are spaced equally apart.
	   For each subset of values the number of iterations required to find the country + date combination is given
	   The best case, the worst case and the aveage case is determined for each seperate subset
	   Each result is written to a separate textfile ranging from sample1 to sample10 for the 10 substet values.
	   The method also takes in the subset value, the Date and the PrintWriter file as arguments.
	**/      
	      public static String calculatesubsets(int subset,String sDate){  
	         Random randNum=new Random();        
	         int opCount = 0;
	         int average = 0;   
	         int smallest = 0;
	         int biggest = aCountry.SearchOperation();
	         int  max=subset;
	         int  min=1;
	         int  n_subset=min+ randNum.nextInt(max);
	         
	         for(int p=0;p<subset -1;p++){
	         		  int l=n_subset;  
	           if (l+p > 9919){
	            System.out.println("Number of lines exceeded");
	            break;
	           }else{    
	              System.out.println(printComparisons(arrCountry[l+p],sDate,aCountry.root,subset));
	              
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
	             System.out.println(average);
	             System.out.println("The average case is" + average +"|The worst case is "+biggest + "|And the best case is "+ smallest) ; 
	      //       sampledata.println("The average case is" + average +"|The worst case is "+biggest + "|And the best case is "+ smallest); 
	            return ("The average case " + average +" " +opCount +" "+ subset);
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
		             System.out.println(average);
		             System.out.println("The average case is" + average +"|The worst case is "+biggest + "|And the best case is "+ smallest) ; 

		   return result;
		   
	   }
	   
	   /**
	   This method is used to create 10 different textfiles named from sample1.txt to sample10.txt to store the results from
	   calculating the iterations required to find the country + date combinations for each of the 10 different subset values.
	   The method then calls the calculatesubsets method to write the results to the 10 different textfiles for the 10 different subsets
	   There is only one argument, it is the date
	 */
	    public static void createFiles(int ram_no,String sDate) throws IOException{
	     
	   //  FileWriter w=new FileWriter(new File("first_BSTAnd_Comparison.txt"),true);
	     
	  //   PrintWriter first_subset=new PrintWriter(w);     
	     int MAX_WORD_LEN = ram_no; // making this dynamic left as an excercise
	     List<PrintWriter> writers = new ArrayList<PrintWriter>();

	     for (int i = 0; i <= MAX_WORD_LEN; i++) {
	         PrintWriter randomized_file = new PrintWriter("C:/UCT/Assignment 2/RandomizedData/Randomizedfile" + i + ".txt", "UTF-8");
	         writers.add(randomized_file);
	         randomizeData(arrCountry,9919,sDate,randomized_file);
	     }

	/**     String line;
	     while ((line = tr.readLine()) != null) {
	        int len = line.length();
	        if (len < writers.size()) {
	            writers.get(len).println(line);
	        }
	     }
      */
	     for (PrintWriter randomized_file : writers) {
	         randomized_file.close();
	     }
	     
	  }

	
   public static void main(String[] args) throws IOException {
	   Scanner keyboard = new  Scanner(System.in);
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
		   String allData = country + date + noOfVaccine;
		   
		   aCountry.insert(country);
		   second_avl.insert(country);
		   counter++;
	   }
	   
       System.out.println("Enter the date: ");
       sDate = keyboard.nextLine();
	   
/**	   for (int a = 0;a < 9918;a++)
	   {
		   
		   System.out.println(arrCountry[a]);
	   }
	*/  
      // randomizeData(arrCountry,9918);
      // System.out.println("Second randozimation");
       createFiles(20,sDate);
   }
}
