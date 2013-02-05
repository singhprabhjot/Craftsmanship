package com.cmu.sv.prabhjot;

public class WeighingStoneAlgorithm {

	public static void main(String[] args) {
		WeighingStoneAlgorithm stoneObj=new WeighingStoneAlgorithm();
		int noOfStones=4;
		int stoneWeightsArray[]=stoneObj.solveIt(noOfStones);
		stoneObj.printResult(stoneWeightsArray);
		stoneObj.testResult(stoneWeightsArray);
	}

	private void printResult(int[] resultsArray) {
		System.out.println("The weights are ");
		for (int i=0;i<resultsArray.length;i++){
			System.out.println(resultsArray[i] +"  ");
		}
		
	}

	private int[] solveIt(int arrayLength) {
		int resultsArray[]=new int[arrayLength];
		resultsArray[0]=1;	
     		for (int stoneNo=1;stoneNo<arrayLength;stoneNo++) {
     			int sum=0;
     			for(int x=0;x<=stoneNo;x++)
     			{
     				sum+=resultsArray[x];
     			}
     			resultsArray[stoneNo]=2*sum+1;
     		}
     		return resultsArray;
	}

	private void testResult(int[] resultsArray) {
		int result=0;
		int stoneOneSide=0,stoneTwoSide=0,stoneThreeSide=0, stoneFourSide=0;
		int maxWeightToMeasure=40;
		for (int x=1;x<=maxWeightToMeasure;x++){
				// Pattern found in results:  x1 changes every time, x2 changes after three times, x3 changes after 9 times, x4 changes after 27 times.				
				stoneOneSide=change_value(stoneOneSide);
				if (((x+1)%3)==0){
					stoneTwoSide=change_value(stoneTwoSide);					
				}
				if (((x+4)%9)==0){
					stoneThreeSide=change_value(stoneThreeSide);
				}
				if (((x+13)%27)==0){
					stoneFourSide=change_value(stoneFourSide);
				}
				result=stoneOneSide*resultsArray[0]+stoneTwoSide*resultsArray[1]+stoneThreeSide*resultsArray[2]+stoneFourSide*resultsArray[3];
				System.out.println( "Result:"+ result);
//				System.out.println( "No:"+ result+"is made by"+	x1 +"X"+resultsArray[0]+"  "+x2+"X"+resultsArray[1]+"  "+ x3+"X"+resultsArray[2]+"  "+x4+"X"+resultsArray[3]);
			}		
		}



	private int change_value(int x) {
		switch (x) {
			case 1:
				x=-1;
				break;
			case -1:
				x=0;
				break;
			case 0:
				x=1;
				break;
			
			default:
				break;
			}
		return x;
	}
}