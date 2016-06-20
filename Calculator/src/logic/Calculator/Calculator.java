package logic.Calculator;

import java.util.ArrayList;

import logic.Parser.Tokenizer;



public class Calculator {
	
	private ArrayList<Polynomial> _tmpPolynomialsList;
	private Tokenizer _myTokenizer;
	
	public Calculator(){
		_tmpPolynomialsList = new ArrayList<>();
		_myTokenizer = new Tokenizer();
	}
	
	public Polynomial joinPolynomial(String pInput){		
		ArrayList<ArrayList<Integer>> tmpPolynomials = _myTokenizer.getPolynomials(pInput);
		Polynomial tmpPolynomial = null;
		if (tmpPolynomials.size() == 1){
			tmpPolynomial = new Polynomial(tmpPolynomials.get(0).get(0), tmpPolynomials.get(0).get(1), tmpPolynomials.get(0).get(2));
		}
		else{
			for (int i = 0; i < tmpPolynomials.size(); i++){
				_tmpPolynomialsList.add(new Polynomial(tmpPolynomials.get(i).get(0), tmpPolynomials.get(i).get(1), tmpPolynomials.get(i).get(2)));
			}
			int i = 0;
			while( i < _tmpPolynomialsList.size()){
				if (i == 0){
					tmpPolynomial = _tmpPolynomialsList.get(i).plus(_tmpPolynomialsList.get(i + 1));
					i += 2;
				}
				else{
					tmpPolynomial = tmpPolynomial.plus(_tmpPolynomialsList.get(i));
					i++;
				}
			}
		}
		_tmpPolynomialsList.clear();
		return tmpPolynomial; 
	}	
	
	
	public static void main(String[] args) {
		 String input = "1 1 1 | -1 1 1";
		 Calculator ca = new Calculator();
		 ca.joinPolynomial(input);
	}
	
}
