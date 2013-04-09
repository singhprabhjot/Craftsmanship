package com.clover.prabhjot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CupidMatchAlgorithm {

	public static void main(String[] args) {
		CupidMatchAlgorithm cupidObj=new CupidMatchAlgorithm();
		ArrayList<Profile> profileArrayList=cupidObj.readProfileJson();
		ArrayList<Profile> profileResultArrayList=cupidObj.makeMatch(profileArrayList);
		boolean isPublished=cupidObj.makeJSON(profileResultArrayList);
		if(isPublished){
			System.out.println("JSON file is published in the project directory");			
		}
	}
	
	private ArrayList<Profile> makeMatch(ArrayList<Profile> profileArrayList) {	
		ArrayList<Profile> profileResultArrayList=new ArrayList<Profile>();
		for(Profile firstProfile:profileArrayList){
			Profile profileObj= getScoresForFirstProfile(firstProfile,profileArrayList);
			profileResultArrayList.add(profileObj);		
		}
		return profileResultArrayList;		
	}
	

	private Profile getScoresForFirstProfile(
			Profile firstProfile, ArrayList<Profile> profileArrayList) {
		ArrayList<Score> scoresArrayListForOneProfile=new ArrayList<Score>();
		Profile profileObj=new Profile();
		for(Profile secondProfile:profileArrayList){
			Score scoreObj=matchTwoProfiles(firstProfile,secondProfile);
			scoresArrayListForOneProfile.add(scoreObj);
		}
		profileObj.setId(firstProfile.getId());
		profileObj.setScores(scoresArrayListForOneProfile);
		return profileObj;
	}

	private Score matchTwoProfiles(Profile firstProfile, Profile secondProfile) {
		Score scoreObj=new Score();
		boolean isDifferent=checkBothProfilesAreDifferent(firstProfile,secondProfile);
		if (isDifferent){
			float score=0;
				float scoreFirstWithSecond=compareProfile(firstProfile,secondProfile);
				float scoreSecondWithFirst=compareProfile(secondProfile,firstProfile);
				score=(float) Math.sqrt(scoreFirstWithSecond*scoreSecondWithFirst);								
				scoreObj.setProfileID(secondProfile.getId());
				scoreObj.setScore(score);			
		}
		return scoreObj;
		
	}

	private boolean checkBothProfilesAreDifferent(Profile secondProfile, Profile firstProfile) {
		if(firstProfile.getId()==secondProfile.getId()){
			return false;
		}
		return true;	
	}

	private float compareProfile(Profile firstProfile, Profile secondProfile) {	
		HashMap quesAnsMapForFirstProfile=firstProfile.getQuestionAnswersMap();
		Iterator quesAnsIteratorObj = quesAnsMapForFirstProfile.entrySet().iterator();
		float numerator=0F;
		float denominator=0F;
		while (quesAnsIteratorObj.hasNext()) {
		      Map.Entry pairs = (Map.Entry)quesAnsIteratorObj.next();
		      long questionID= (Long) pairs.getKey();
		      QuestionAnswers quesAnsObj= (QuestionAnswers) pairs.getValue();
		      denominator=denominator+quesAnsObj.getWeightedImportance();
		      if (secondProfile.getQuestionAnswersMap().containsKey(questionID)){
		    	  QuestionAnswers secondProfileQuesAnsObj=  (QuestionAnswers) secondProfile.getQuestionAnswersMap().get(questionID);
		    	boolean isMatch=matchThisQuestionWithSecondProfileAnswer(quesAnsObj,secondProfileQuesAnsObj,questionID);
		    	if(isMatch){	
		    		numerator=numerator+quesAnsObj.getWeightedImportance();
		    	}		    	
		      }	    	  
			}
		return (numerator/denominator*100);
	}

	private boolean matchThisQuestionWithSecondProfileAnswer(QuestionAnswers quesAnsObj,
		QuestionAnswers secondProfileQuesAnsObj, long questionID) {
		Set accepatableAnswerSetForFirstProfile=quesAnsObj.getAcceptableAnswers();
		if(accepatableAnswerSetForFirstProfile.contains(secondProfileQuesAnsObj.getMyAnswer())){
			return true;
		}				
		return false;
	}

	public ArrayList<Profile> readProfileJson(){
		ParseJSON parseObj=new ParseJSON();
		ArrayList<Profile> profileArrayList=null;
		try {
		 profileArrayList=parseObj.parseJson();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return profileArrayList;
	}
	
	private boolean makeJSON(ArrayList<Profile> profileResultArrayList) {
		CreateJSON createJSONObj=new CreateJSON();
		return createJSONObj.createJSONFile(profileResultArrayList);		
	}
}
