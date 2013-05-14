package fibonnaci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Fibonnaci {
	
	private static boolean _bool;
	private static int _term;
	private static String[] info = new String[] {Strings.WELCOME, Strings.ARG_TRUE, Strings.ARG_INT, Strings.EXAMPLE_1, Strings.EXAMPLE_2, Strings.ENJOY};

	public static void main(String[] args) {
		printInfo();
		while(System.in != null) {
			/* Set up interface */
			getUserInput();
		}
	}

	public static void getUserInput() {
		System.out.println(Strings.BEGIN);
		Scanner read = new Scanner(System.in);
		String cmd = read.nextLine();
		if(!isValidFunction(cmd)) {
			System.out.println(Strings.NOT_VALID);
		} else {
			
		}
	}

	public static void printInfo() {
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i] + Strings.NEWLINE);
		}
	}

	public static boolean isValidFunction(String function_call) {
		if (function_call.contains("fibonnaci")) {
			if(hasArgs(function_call)) {
				setMethodAndArgs(function_call);
				return true;
			} else {
				System.out.println(Strings.NO_ARGS);
				System.exit(0);
				return false;
			}
		} else {
			return false;
		}
	}

	private static boolean hasArgs(String cmd) {
		// TODO Auto-generated method stub
		cmd = cmd.substring("fibonnaci".length(), cmd.length());
		if (cmd.contains("true")) {
			return true;
		}
		if(cmd.matches(".*\\d.*")) {
			return true;
		}
		return false;
	}

	private static void setMethodAndArgs(String cmd) {
		// TODO Auto-generated method stub
		cmd = cmd.substring("fibonnaci".length(), cmd.length()); 
		if(cmd.contains("true")) {
			setBool(true);
			cmd = cmd.substring("true".length() + 2, cmd.length());
			cmd.replaceAll("\\s","");
			int term = Integer.parseInt(cmd);
			setTerm(term);
			fibonnaci(getBool(), getTerm());
		} else {
			cmd = cmd.substring(1, cmd.length());
			cmd.trim();
			int term = Integer.parseInt(cmd);
			setTerm(term);
			fibonnaci(getTerm());
		}
	}

	
	public static void setTerm(int term) {
		_term = term;
	}
	
	public static int getTerm() {
		return _term;
	}
	
	public static void setBool(Boolean bool) {
		_bool = bool;
	}
	
	public static boolean getBool() {
		return _bool;
	}


	public static void fibonnaci(int term) {
		List<Integer> terms = new ArrayList<Integer>();
		terms.add(0);
		terms.add(1);
		int i = 2;
		while (i <= term) {
			terms.add(terms.get(i - 1) + terms.get(i - 2));
			i++;
		}
		System.out.println(terms.get(term));
	}

	public static void fibonnaci(boolean print, int term) {
		List<Integer> terms = new ArrayList<Integer>();
		terms.add(0);
		terms.add(1);
		int i = 2;
		while (i <= term) {
			terms.add(terms.get(i - 1) + terms.get(i - 2));
			i++;
		}
		System.out.println(terms);
	}

}
