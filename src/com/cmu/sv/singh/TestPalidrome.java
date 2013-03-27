package com.cmu.sv.singh;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalidrome extends PalindromeNewAlgorithm{

	@Test
	public void testPalidrome() {
		PalindromeNewAlgorithm objPalAlgorithm=new PalindromeNewAlgorithm();
		String testString="";
		
		//check for correct palindrome
		testString="A man, a plan, a canal: Panama";
		assertEquals(true, objPalAlgorithm.checkForPalindrome(testString));
		
		//check for odd no of characters
		testString="ABCXCBA";
		assertEquals(true, objPalAlgorithm.checkForPalindrome(testString));
		
		//check for even no of characters
		testString="ABCCBA";
		assertEquals(true, objPalAlgorithm.checkForPalindrome(testString));

		testString="bananab";
		assertEquals(true, objPalAlgorithm.checkForPalindrome(testString));
		
		//check for wrong palindrome
		testString="ABCXBC";
		assertEquals(false, objPalAlgorithm.checkForPalindrome(testString));
		
		//check for wrong palindrome
		testString="A man, a plan,: Panama";
		assertEquals(false, objPalAlgorithm.checkForPalindrome(testString));
	}

}
