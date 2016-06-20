package calculator.GUI;

import java.util.ArrayList;
import java.util.Scanner;

import logic.Calculator.Polynomial;
import logic.Parser.Tokenizer;
import facade.Facade;

public class CommandLine {
	private String _consoleInput;
	private Facade facade;
	private ArrayList<String> _operator;
	private ArrayList<Polynomial> _polynomialList;
	private Tokenizer myTokenizer;
	
	public CommandLine(){
		_consoleInput = new String();
		facade = new Facade();
        _operator = new ArrayList<>();
        _polynomialList = new ArrayList<>();
        myTokenizer = new Tokenizer();
	}
	
	
	public void startCommandLine(){
		System.out.println("Calculator, enter operations: ");
		
		Scanner user_input = new Scanner(System.in);
		_consoleInput = user_input.nextLine();
		
			
	}
}
