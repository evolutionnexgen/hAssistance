package com.example.snmc.controller.nodel;

public class Timer {

	private int maxRespondTime;
	private int maxReachTime;
	private int avgServiceTime;
	private int docVisitTime;

	public int getMaxRespondTime() {
		return maxRespondTime;
	}

	public void setMaxRespondTime(int maxRespondTime) {
		this.maxRespondTime = maxRespondTime;
	}

	public int getMaxReachTime() {
		return maxReachTime;
	}

	public void setMaxReachTime(int maxReachTime) {
		this.maxReachTime = maxReachTime;
	}

	public int getAvgServiceTime() {
		return avgServiceTime;
	}

	public void setAvgServiceTime(int avgServiceTime) {
		this.avgServiceTime = avgServiceTime;
	}

	public int getDocVisitTime() {
		return docVisitTime;
	}

	public void setDocVisitTime(int docVisitTime) {
		this.docVisitTime = docVisitTime;
	}

}
