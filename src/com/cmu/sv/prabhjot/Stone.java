package com.cmu.sv.prabhjot;

public class Stone {


	public static void main(String[] args) {
		Stone stoneObj=new Stone();
		int arrayLength=4;
		int resultsArray[]=stoneObj.getNumbers(arrayLength);
		stoneObj.printResult(resultsArray);
		stoneObj.testNumbers(resultsArray);
	}

	private void printResult(int[] resultsArray) {
		System.out.println("The weights are ");
		for (int i=0;i<resultsArray.length;i++){
			System.out.println(resultsArray[i] +"  ");
		}
		
	}

	private int[] getNumbers(int arrayLength) {
		int resultsArray[]=new int[arrayLength];
		resultsArray[0]=1;	
     		for (int itemNo=1;itemNo<arrayLength;itemNo++) {
     			int sum=0;
     			for(int x=0;x<=itemNo;x++)
     			{
     				sum+=resultsArray[x];
     			}
     			resultsArray[itemNo]=2*sum+1;
     		}
     		return resultsArray;
	}

	private void testNumbers(int[] resultsArray) {
		int result=0;
		for (int x=1,x1=0,x2=0,x3=0, x4=0;x<=40;x++){
				// Pattern found in results:  x1 changes every time, x2 changes after three times, x3 changes after 9 times, x4 changes after 27 times.				
				x1=change_value(x1);
				if (((x+1)%3)==0){
					x2=change_value(x2);					
				}
				if (((x+4)%9)==0){
					x3=change_value(x3);
				}
				if (((x+13)%27)==0){
					x4=change_value(x4);
				}
				result=x1*resultsArray[0]+x2*resultsArray[1]+x3*resultsArray[2]+x4*resultsArray[3];
				System.out.println( "Result:"+ result);
//				System.out.println( "No:"+ result+"is made by"+	x1 +"X"+resultsArray[0]+"  "+x2+"X"+resultsArray[1]+"  "+ x3+"X"+resultsArray[2]+"  "+x4+"X"+resultsArray[3]);
			}		
		}



	private int change_value(int x) {
		if (x==1){
			x=-1;
			}
		else if (x==-1) {
			x=0;	
		}
		else {
			x=1;
		}
		return x;
	}
}