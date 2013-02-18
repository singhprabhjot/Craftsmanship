package com.cmu.sv.prabhjot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestLengthAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestLengthAlgorithm llaObj=new LongestLengthAlgorithm();
		int inputArray[]= llaObj.getInput();
		int longestLengthArrayBoundaries[]=llaObj.findLongestRun(inputArray);
		llaObj.printLongestRun(longestLengthArrayBoundaries);
		llaObj.testAlgorithm();
	}
	
	

	private void testAlgorithm() {
		int[] testArray={10,12,13,14,9,8,0,3,4,5,2,19,234,11};
		int longestLengthArrayBoundaries[]=findLongestRun(testArray);
		if (longestLengthArrayBoundaries[0]==8 && longestLengthArrayBoundaries[1]==14)
			System.out.println("Test Passed");		
	}

	private void printLongestRun(int[] longestLengthArrayBoundaries) {
		System.out.print("[");
		for (int i=longestLengthArrayBoundaries[0];i<=longestLengthArrayBoundaries[1];i++){
			System.out.print(i +" ");
		}
		System.out.println("]");
	}



	private int[] findLongestRun(int[] inputArray) {
		Set setOfInputElements= convertArrayToSet(inputArray);
		
		int maxLengthOfRun=1;
		int[] longestLengthArrayBoundaries={0,0};	
		Iterator itrObj = setOfInputElements.iterator();
		
		while (itrObj.hasNext()) {
			int elementInSet = (Integer) itrObj.next();
			itrObj.remove();
			int lastForwardValue=findForwardBoundary(setOfInputElements,elementInSet);
			int lastBackwardValue=findBackwardBoundary(setOfInputElements,elementInSet);
			if (maxLengthOfRun<(lastForwardValue-lastBackwardValue)){
				maxLengthOfRun=lastForwardValue-lastBackwardValue;
				longestLengthArrayBoundaries[1]=lastForwardValue;
				longestLengthArrayBoundaries[0]=lastBackwardValue;
			}

		}	
		return longestLengthArrayBoundaries;
	}


	private int findBackwardBoundary(Set setOfInputElements,
			int elementInSet) {
		int lastBackwardValue=elementInSet;		
		while (setOfInputElements.contains(lastBackwardValue-1)){
//			setOfInputElements.remove(lastForwardValue-1);
			lastBackwardValue--;
		}
		return lastBackwardValue;
	}



	private int findForwardBoundary(Set setOfInputElements,
			int elementInSet) {
		int lastForwardValue=elementInSet;			
		while (setOfInputElements.contains(lastForwardValue+1)){
			lastForwardValue++;
//			setOfInputElements.remove(lastForwardValue+1);
		}
		return lastForwardValue;
	}


	private int[] getInput() {
		int[] inputArray={10,21,45,22,7,2,67,19,13,45,12,11,18,16,17,100,201,20,101};
		return inputArray;
	}

	
	  public  Set convertArrayToSet(int[] inputArray) {
	      Set resultSet = new HashSet();
	      for (int i = 0; i < inputArray.length; i++) {
	          resultSet.add((inputArray[i]));
	      }	      
	      return resultSet;
	  }
	  
}
