package com.clover.prabhjot;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile {
	private	long id;
	private long score;
	private HashMap questionAnswersMap; 
	private ArrayList<Score> scoreObj;
	
	public Profile(){
		id=0;
		questionAnswersMap=new HashMap();
	}

	public HashMap getQuestionAnswersMap() {
		return questionAnswersMap;
	}


	public void setQuestionAnswersMap(HashMap questionAnswersMap) {
		this.questionAnswersMap = questionAnswersMap;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}
	
	public ArrayList<Score> getScores() {
		return scoreObj;
	}
	public void setScores(ArrayList<Score> scoresObj) {
		this.scoreObj = scoresObj;
	}
}
