package com.clover.prabhjot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJSON {
     public ArrayList<Profile> parseJson() {
    	 JSONParser parser = new JSONParser();
    	 ArrayList<Profile> profileArrayList=new ArrayList<Profile>();
		    try {
		       Object obj = parser.parse(new FileReader("input.json"));
		       JSONObject jsonObject =  (JSONObject) obj;  
		       JSONArray profileArray=new JSONArray();
		       profileArray=(JSONArray) jsonObject.get("profiles");
		       profileArrayList=parseEveryProfile(profileArray);    
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
			return profileArrayList;
     }
     
     private ArrayList<Profile> parseEveryProfile(JSONArray profileArray) {
         ArrayList<Profile> profileArrayList=new ArrayList<Profile>();
         for(int i=0;i<profileArray.size();i++){
	      	  JSONObject jsonObj=(JSONObject) profileArray.get(i);
	      	  long id= (Long) jsonObj.get("id");
	      	  Profile profileObj=new Profile();
	      	  profileObj.setId(id);
	      	  JSONArray answersArray=(JSONArray) jsonObj.get("answers");
	      	  HashMap quesAnswerMap= parseQuestionAnswers(answersArray);
	      	  profileObj.setQuestionAnswersMap(quesAnswerMap); 
	      	  profileArrayList.add(profileObj);
         }
         return profileArrayList;
		
	}  

     private HashMap parseQuestionAnswers(JSONArray answersArray){
     HashMap quesAnswerMap=new HashMap();
   	  for (int j=0;j<answersArray.size();j++){
		  QuestionAnswers qaObj=new QuestionAnswers();
		  JSONObject jsonObject=(JSONObject) answersArray.get(j);
		  long importance= (Long) jsonObject.get("importance");
		  qaObj.setImportance(importance);
   		  long questionID= (Long) jsonObject.get("questionId");
		  qaObj.setQuestionID(questionID);
 		  long myAnswer= (Long) jsonObject.get("answer");
		  qaObj.setMyAnswer(myAnswer);	  
		  JSONArray acceptableAnswerArray=(JSONArray) jsonObject.get("acceptableAnswers"); 
		  Set acceptableAnswerSet=parseAcceptedAnswers(acceptableAnswerArray);
		  qaObj.setAcceptableAnswers(acceptableAnswerSet);
		  quesAnswerMap.put(questionID, qaObj);
	  }
   	  return quesAnswerMap;
     }
     
     private Set parseAcceptedAnswers(JSONArray acceptableAnswerArray){
	   	  Set acceptableAnswers=new HashSet();
		  for (int k=0;k<acceptableAnswerArray.size();k++){
			  acceptableAnswers.add(acceptableAnswerArray.get(k));	
		  }
		  return acceptableAnswers;			  
     }
}