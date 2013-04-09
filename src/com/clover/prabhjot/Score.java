package com.clover.prabhjot;

public class Score {
	private float score;
	private long profileID;
	
	public Score() {
		score=0;
		profileID=-1;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public long getProfileID() {
		return profileID;
	}
	public void setProfileID(long profileID) {
		this.profileID = profileID;
	}
	
}
