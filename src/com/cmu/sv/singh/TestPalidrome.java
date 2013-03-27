package com.cmu.sv.singh;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalidrome{
	PalindromeNewAlgorithm objPalAlgorithm;

	public TestPalidrome(){
		objPalAlgorithm=new PalindromeNewAlgorithm();
	}

	@Test
	public void testPalidrome() {
		String testString="";
		
		//check for correct palindrome
		testString="A man, a plan, a canal: Panama";
		assertEquals(true, test(testString));
		
		//check for odd no of characters
		testString="ABCXCBA";
		assertEquals(true, test(testString));
		
		//check for even no of characters
		testString="ABCCBA";
		assertEquals(true, test(testString));

		testString="bananab";
		assertEquals(true, test(testString));
		
		//check for wrong palindrome
		testString="ABCXBC";
		assertEquals(false, test(testString));
		
		//check for wrong palindrome
		testString="A man, a plan,: Panama";
		assertEquals(false,test(testString) );
	}
	
	public boolean test(String testString){
		return objPalAlgorithm.checkForPalindrome(testString);
	}

}
