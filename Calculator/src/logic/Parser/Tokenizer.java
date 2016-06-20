package logic.Parser;

import java.awt.List;
import java.util.ArrayList;

public class Tokenizer {
	
	private static final String expressionPattern = "(-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)(\\ \\|\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+))*";
	
	public Tokenizer(){	
	}
	
	public boolean verifyInput(String pInput){
		if (pInput.matches(expressionPattern))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param pInput
	 * @return <ArrayList<String>> 
	 * 
	 * If the input is: 1 2 3 | 4 5 6
	 * The output will be:
	 * <<1,2,3>,<4,5,6>> 
	 */
	public ArrayList<ArrayList<Integer>> getPolynomials(String pInput){
		//A split of the list of polynomials	
		String[] inputList = pInput.split("\\|");
		//this variable will store a list of string[], which will store all the polynomial
		ArrayList<String[]> tmp = new ArrayList<>();
		
		//Split of each polynomial, and adding each character to a list of strings
		for (int i = 0; i < inputList.length; i++) {
			 tmp.add(inputList[i].split(""));
		}
		
		//This will store the final list of polynomials
		ArrayList<ArrayList<Integer>> plynomialsList = new ArrayList<>();
		//---------------------------------principal for begins------------------------------//
		/**
		 * This for will iterate over all the list of polynomials
		 */
		 for (int i = 0; i < tmp.size(); i++) {
			 int x = 0;
			 //System.out.println("size de tmp: " + tmp.get(i).length);
			//--------------------principal while begins---------------------//
			 /**
			  * This while will iterate over each polynomial
			  */
			 ArrayList<Integer> tmp2 = new ArrayList<>();
			 while(x < tmp.get(i).length){ 				 				 
				 if(tmp.get(i)[x].equals("-")){ //if the digit is negative
					 String addMinus = tmp.get(i)[x];
					 /**
					  * Iterate over the list adding all the numbers and will stop until it find a space, 
					  */
					 for (int j = x +1; j < tmp.get(i).length; j++){
						 if((tmp.get(i)[j].equals("0") || tmp.get(i)[j].equals("1") || tmp.get(i)[j].equals("2") || tmp.get(i)[j].equals("3") || tmp.get(i)[j].equals("4") || tmp.get(i)[j].equals("5") || tmp.get(i)[j].equals("6") ||
									tmp.get(i)[j].equals("7") || tmp.get(i)[j].equals("8") || tmp.get(i)[j].equals("9"))){
							 addMinus = addMinus + tmp.get(i)[j];	
							 x++;
						 }
						 else{
							 break;
						 }
							 						 
					 }						 
					 tmp2.add(java.lang.Integer.parseInt(addMinus));
				 }
				 //Verify if there is any number
				 else if ((tmp.get(i)[x].equals("0") || tmp.get(i)[x].equals("1") || tmp.get(i)[x].equals("2") || tmp.get(i)[x].equals("3") || tmp.get(i)[x].equals("4") || tmp.get(i)[x].equals("5") || tmp.get(i)[x].equals("6") ||
						tmp.get(i)[x].equals("7") || tmp.get(i)[x].equals("8") || tmp.get(i)[x].equals("9"))){
					 
					 String add = tmp.get(i)[x]; 
					 
					 /**
					  * Iterate over the list adding all the numbers and will stop until it find a space, 
					  */
					 for (int j = x +1; j < tmp.get(i).length; j++){
						 if((tmp.get(i)[j].equals("0") || tmp.get(i)[j].equals("1") || tmp.get(i)[j].equals("2") || tmp.get(i)[j].equals("3") || tmp.get(i)[j].equals("4") || tmp.get(i)[j].equals("5") || tmp.get(i)[j].equals("6") ||
									tmp.get(i)[j].equals("7") || tmp.get(i)[j].equals("8") || tmp.get(i)[j].equals("9"))){
							 add = add + tmp.get(i)[j];	
							 x++;
						 }
						 else{
							 break;
						 }
							 						 
					 }						 
					 tmp2.add(java.lang.Integer.parseInt(add));
				 }				 
				 x++;
			}	
			//-------------------principal while ends---------------------// 
			if (tmp2.size() != 0)
				plynomialsList.add(tmp2);			
	 	}		 
		//---------------------------------principal for ends------------------------------//
		return plynomialsList;
	}

	public static void main(String[] args) {
		 String input = "1 2 3";
		 Tokenizer myTok = new Tokenizer();
		 System.out.println(myTok.verifyInput(input));		 
		 if (myTok.verifyInput(input)){			 
			 ArrayList<ArrayList<Integer>> p = myTok.getPolynomials(input);
			 for (int i = 0; i < p.size(); i++ ){
				 for (int j = 0; j < p.get(i).size(); j++ ){
					 int x = (i+1)*(j+1);
					 System.out.println("index: " + x+ "  " + (p.get(i).get(j)));
				 }
			 }
		 }
	}
	
}
