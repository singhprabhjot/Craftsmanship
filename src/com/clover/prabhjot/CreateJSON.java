package com.clover.prabhjot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSON {

	public boolean createJSONFile(ArrayList<Profile> profileResultArrayList) {	 
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArrayObj=createResultsArray(profileResultArrayList);
		jsonObj.put("results",jsonArrayObj);	 
		try {
			FileWriter file = new FileWriter("output.json");
			file.write(jsonObj.toJSONString());
			file.flush();
			file.close(); 
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private JSONArray createResultsArray(
			ArrayList<Profile> profileResultArrayList) {
		JSONArray jsonArrayObj=new JSONArray();
		for (Profile profileObj : profileResultArrayList) {	
			JSONObject jsonObj=new JSONObject();
			JSONArray jsonScoresArray=createJSONScoresArray(profileObj);
			jsonObj.put("scores", jsonScoresArray);
			jsonObj.put("profileId", profileObj.getId());
			jsonArrayObj.add(jsonObj);
		}
		return jsonArrayObj;
	}

	private JSONArray createJSONScoresArray(Profile profileObj) {
		JSONArray jsonScoresArray=new JSONArray();
		ArrayList<Score> scoresArrayList=profileObj.getScores();
		for (Score score : scoresArrayList) {
			JSONObject jsonObj=new JSONObject();
			if((profileObj.getId()==score.getProfileID())||(score.getProfileID()<0)){
				continue;
			}
			jsonObj.put("score", score.getScore());
			jsonObj.put("profileId", score.getProfileID());	
			jsonScoresArray.add(jsonObj);
		}
		return jsonScoresArray;
	}	
}
