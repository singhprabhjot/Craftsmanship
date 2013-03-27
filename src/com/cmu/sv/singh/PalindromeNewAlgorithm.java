package com.cmu.sv.singh;

import java.util.Scanner;

public class PalindromeNewAlgorithm {
	
	public static void main(String[] args) {
		PalindromeNewAlgorithm pldNewAlgoObj=new PalindromeNewAlgorithm();
		String inputString=pldNewAlgoObj.getInputString();
		boolean result=pldNewAlgoObj.checkForPalindrome(inputString);
		System.out.println(result);
	}

	private String getInputString() {
		System.out.println("Please enter the string.");
		Scanner scanObj=new Scanner(System.in);
		String inputString=scanObj.nextLine();
		return inputString;
	}

	public boolean checkForPalindrome(String inputString) {
		inputString=inputString.toUpperCase();
		int firstCharIndex=0;
		int lastCharIndex=inputString.length()-1;
		for(;firstCharIndex<=lastCharIndex;firstCharIndex++,lastCharIndex--) {	
			while (!isValidCharacter(inputString.charAt(firstCharIndex))){
				firstCharIndex++;
			}
			while(!isValidCharacter(inputString.charAt(lastCharIndex))) {
				lastCharIndex--;
			}
			if(inputString.charAt(firstCharIndex)!=inputString.charAt(lastCharIndex)) {
				return false;
			}
		}
		return true;		
	}

	private boolean isValidCharacter(char inputCharacter) {
		int asciiValueOfChar=inputCharacter;
		if(asciiValueOfChar < 65 || asciiValueOfChar > 90) {
			return false;
		}
		return true;
	}
}
