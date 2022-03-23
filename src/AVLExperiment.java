import java.util.*;
import java.io.*;



public class AVLExperiment {
	static String[] arrCountry = new String[9919]; 
	static String[] arrDate = new String[9919];
	static String[] arrnoOfVaccines = new String[9919];
	public static BinaryTree btree = new BinaryTree();
	public static AVLTree first_avl = new AVLTree();
	public static AVLTree second_avl = new AVLTree();
	public static AVLTree<String> aCountry;
	public static AVLTree<String>  avl_tree;
	public static int bestcase,worstcase;
	
	
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
	      bestcase = avl.OperationsCount();
	      for(int a = 0;a < 9918;a++){
	         if((arrCountry[a] + arrDate[a]).equals(data + day)){
	             check = true;
	             result = ("There are  "+btree.OperationsCount() + " iterations for "+ arrCountry[a] );
	                  if(bestcase > btree.OperationsCount())
	                   bestcase = btree.OperationsCount(); 
	                  
	                  if(worstcase < btree.OperationsCount())
	                   worstcase = btree.OperationsCount();
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

	/*
	   This method is used to test the traditional array using 10 different subsets of values that are spaced equally apart.
	   For each subset of values the number of iterations required to find the country + date combination is given
	   The best case, the worst case and the aveage case is determined for each seperate subset
	   Each result is written to a separate textfile ranging from sample1 to sample10 for the 10 substet values.
	   The method also takes in the subset value, the Date and the PrintWriter file as arguments.
	**/      
	      public static String calculatesubsets(int subset,String sDate,PrintWriter sampledata){  
	         Random randNum=new Random();        
	         int opCount = 0;
	         int average = 0;   
	         int smallest = aCountry.SearchOperation();
	         int biggest = aCountry.SearchOperation();
	         int  max=subset;
	         int    min=1;
	         int  n_subset=min+ randNum.nextInt(max);
	         for(int p=0;p<subset -1;p++){
	         		  int l=n_subset;  
	           if (l+p > 9917){
	            System.out.println("Number of lines exceeded");
	            break;
	           }else{    
	              System.out.println(printComparisons(arrT[l+p],sDate,aCountry.root,subset));
	              
	              opCount = opCount + aCountry.SearchOperation();
	        	     sampledata.println(printComparisons(arrT[l+p],sDate,aCountry.root,subset));
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
	             sampledata.println("The average case is" + average +"|The worst case is "+biggest + "|And the best case is "+ smallest); 
	            return ("The average case " + average +" " +opCount +" "+ subset);
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
		   counter++;
		   
		   String allData = country + date + noOfVaccine;
		   
		   aCountry.insert(country);
		   second_avl.insert(country);
	   }
	   
       System.out.println("Enter the date: ");
       sDate = keyboard.nextLine();
	   
	   for (int a = 0;a < 9919;a++)
	   {
		   
		   System.out.println(arrCountry[a]);
	   }   
	   
   }
}
