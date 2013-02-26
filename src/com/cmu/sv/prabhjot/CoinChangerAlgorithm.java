package com.cmu.sv.prabhjot;

import java.text.BreakIterator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CoinChangerAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CoinChangerAlgorithm ccaObj=new CoinChangerAlgorithm();
		ccaObj.changeCoin();
		ccaObj.testAlgorithm();
	}

	private void testAlgorithm() {
		int testValue=0;
		int[] coinValues = getValueOfCoins();
		
		testValue=0;
		int[]expectedResultFor0={0,0,0,0,0,0};
		getTestResults(testValue,expectedResultFor0,coinValues);
		
		testValue=1;
		int[]expectedResultFor1={1,0,0,0,0,0};
		getTestResults(testValue,expectedResultFor1,coinValues);
		
		testValue=2;
		int[]expectedResultFor2={2,0,0,0,0,0};
		getTestResults(testValue,expectedResultFor2,coinValues);
		
		testValue=9;
		int[]expectedResultFor9={4,1,0,0,0,0};
		getTestResults(testValue,expectedResultFor9,coinValues);
		
		testValue=19;
		int[]expectedResultFor19={4,1,1,0,0,0};
		getTestResults(testValue,expectedResultFor19,coinValues);
		
		testValue=25;
		int[]expectedResultFor25={0,0,0,1,0,0};
		getTestResults(testValue,expectedResultFor25,coinValues);
		
		testValue=51;
		int[]expectedResultFor51={1,0,0,0,1,0};
		getTestResults(testValue,expectedResultFor51,coinValues);
		
		testValue=99;
		int[]expectedResultFor99={4,0,2,1,1,0};
		getTestResults(testValue,expectedResultFor99,coinValues);
		
		
	}
	
	

	private void getTestResults(int testValue, int[] expectedResult,
			int[] coinValues) {
		int[] actualResult= changeTheCoins(testValue,coinValues);
		if (!compareResults(actualResult,expectedResult))
			System.out.println("Test failed" + "::" +testValue);
		
	}

	private boolean compareResults(int[] actualResult, int[] expectedResult) {
		for (int i = 0; i < expectedResult.length; i++) {
			if (actualResult[i]!=expectedResult[i]) {
				return false;
			}
		}
		return true;
	}

	private void changeCoin() {
		int changeValue=getInputFromUser();	
		int[] coinValues = getValueOfCoins();
		int[] coinsAfterChange= changeTheCoins(changeValue,coinValues);
		printResults(coinsAfterChange); 
	}

	private void printResults(int[] coinsAfterChange) {
		System.out.print("[");
		for (int i = 0; i < coinsAfterChange.length; i++) {
			System.out.print(coinsAfterChange[i]+" ");
		}
		System.out.println("]");
	}

	private int[] changeTheCoins(int changeValue, int[] coinValues) {

		int[] resultArray=new int[coinValues.length];
		for (int i=coinValues.length-1;i>=0; i--) {
			if (changeValue/coinValues[i]>=0){
				int numberOfTimesCoinRequired=(int) Math.floor(changeValue/coinValues[i]);
				resultArray[i]=numberOfTimesCoinRequired;
				changeValue=changeValue-coinValues[i]*numberOfTimesCoinRequired;
			}
			if (changeValue==0){
				break;
			}
		}
		return resultArray;
	}

	private int[] getValueOfCoins() {
		int[] coinValues={1,5,10,25,50,100};
		return coinValues;
	}

	private int getInputFromUser() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the amount for change");
		int userInput=reader.nextInt();
		return userInput;
	}
	

}
