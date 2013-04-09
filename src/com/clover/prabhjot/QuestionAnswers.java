package com.clover.prabhjot;

import java.util.HashSet;
import java.util.Set;

public class QuestionAnswers {
	
	private Set acceptableAnswers;
	private long myAnswer;
	private long importance;
	private long questionID;
	
	public QuestionAnswers(){
		importance=0;
		questionID=0;
		acceptableAnswers= new HashSet();;
	}

	public Set getAcceptableAnswers() {
		return acceptableAnswers;
	}

	public void setAcceptableAnswers(Set acceptableAnswers) {
		this.acceptableAnswers = acceptableAnswers;
	}

	public long getWeightedImportance() {
		if(importance==0){
			return 0;
		}else if (importance==1){
			return 1;
		}else if (importance==2){
			return 10;
		}else if (importance==3){
			return 50;
		}else if (importance==4){
			return 250;
		}
		return importance;
	}
	public void setImportance(long importance) {
		this.importance=importance;
	}
	public long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}
	
	public long getMyAnswer() {
		return myAnswer;
	}

	public void setMyAnswer(long myAnswer) {
		this.myAnswer = myAnswer;
	}
}
