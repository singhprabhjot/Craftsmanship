package com.cmu.sv.singh;

import java.util.Scanner;

public class PalindromeAlgorithm {
	private String firstHalf;
	private String secondHalf;
	
	public PalindromeAlgorithm(){
		firstHalf="";
		secondHalf="";
	}
	
	public static void main(String[] args) {
		PalindromeAlgorithm palObj=new PalindromeAlgorithm();
		String inputString = palObj.getInputString();
		boolean isPalindrome=palObj.checkForPalindrome(inputString);
		palObj.printResult(inputString,isPalindrome);		
	}

	protected boolean checkForPalindrome(String inputString) {
		String santizedString=santizeString(inputString);
		divideStringInTwoParts(santizedString);
		if (firstHalf.equals(reverseString(secondHalf))){
			return true;
		}	
		return false;
	}

	private void divideStringInTwoParts(String santizedString) {
		int midPoint=Math.round(santizedString.length()/2);
		if (santizedString.length()%2==0)	{
			firstHalf=santizedString.substring(0, midPoint);
			secondHalf=santizedString.substring(midPoint,santizedString.length());
		}
		else {
			firstHalf=santizedString.substring(0,midPoint);
			secondHalf=santizedString.substring(midPoint+1,santizedString.length());
		}	
	}

	private String reverseString(String inputString) {
		char[] inputCharArray=inputString.toCharArray();
		String reversedString="";
		for (int i=inputCharArray.length;i>0;i--){
			reversedString=reversedString+inputCharArray[i-1];
		}
		return reversedString;
	}

	private String santizeString(String inputString) {
		inputString=inputString.toUpperCase();
		char[] inputStringCharArray=inputString.toCharArray();
		String sanatizedString="";
		for (int i=0; i<inputStringCharArray.length;i++){
			int asciiValue=inputStringCharArray[i];
			if (asciiValue>=65&&asciiValue<=90) {
 				sanatizedString=sanatizedString+inputStringCharArray[i];
			}
		}
		return sanatizedString;
	}

	private String getInputString() {
		System.out.println("Please enter the string.");
		Scanner scanObj=new Scanner(System.in);
		String inputString=scanObj.nextLine();
		return inputString;
	}
	
	private void printResult(String inputString, boolean isPalindrome) {
		System.out.print("'"+inputString + "' is");
		if (isPalindrome){
			System.out.print(" a Palindrome");
		}
		else {
			System.out.print(" not a Palindrome");
		}		
	}
}
