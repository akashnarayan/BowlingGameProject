package com.bowling.classes;

public class Frame {
	
	private int first;
	private int second;
	private int third;
	
	private int score;
	private Frame previousFrame;
	private Frame nextFrame;

	public Frame() {}
	
	public Frame(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Frame getPreviousFrame() {
		return previousFrame;
	}

	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;
	}
	
	public Frame getNextFrame() {
		return nextFrame;
	}

	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}

	@Override
	public String toString() {
		return " [ first=" + first + ", second=" + second + ", third=" + third + ", score=" + score + "]";
	}
	
	
}
