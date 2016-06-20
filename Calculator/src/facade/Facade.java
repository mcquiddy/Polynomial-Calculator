package facade;

import logic.Calculator.Calculator;

public class Facade {
	
	public Calculator _myCalc;
	
	public Facade(){
		_myCalc = new Calculator();
	}
}
