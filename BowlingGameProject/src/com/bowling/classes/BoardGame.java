package com.bowling.classes;

import java.util.LinkedList;

public class BoardGame {
	
	private LinkedList<Frame> frames = new LinkedList<>();
	private Frame currentFrame;
	private boolean firstThrowHasValueInFrameFlag;
	private boolean secondThrowHasValueInFrameFlag;
	private boolean createNewFrame = true;
	
	public void throwBall(int pin) {
		
		// To create the frames
		if(frames.isEmpty()) {
			this.currentFrame = new Frame();
			
		}else if(createNewFrame){
			this.currentFrame = frames.getLast().getNextFrame();
		}
		
		//To populate the values in the cells of each frame
		if(!firstThrowHasValueInFrameFlag && pin!=10) {
			this.currentFrame.setFirst(pin);
			this.resetFirstThrowFrameFlag(true);
			this.resetSecondThrowFrameFlag(false);
			this.resetNewFrameFlag(false);
			
		}else if(!secondThrowHasValueInFrameFlag){
			this.currentFrame.setSecond(pin);
			if(frames.size()<9) {
				this.resetFirstThrowFrameFlag(false);
				this.resetNewFrameFlag(true);
			}
			this.resetSecondThrowFrameFlag(true);
			
		}else if(firstThrowHasValueInFrameFlag && secondThrowHasValueInFrameFlag) {
			this.currentFrame.setThird(pin);
			this.resetNewFrameFlag(false);
			this.frames.add(currentFrame);
		}
		
		//Adding the frames in the list and attaching the new frames with old frames 
		if(createNewFrame) {
			Frame nextFrame = new Frame();
			nextFrame.setPreviousFrame(this.currentFrame);
			this.resetSecondThrowFrameFlag(false);
			
			this.currentFrame.setNextFrame(nextFrame);			
			this.frames.add(currentFrame);
			
		}
	}
	
	private void resetNewFrameFlag(boolean flag) {
		this.createNewFrame = flag;
	}
	
	private void resetFirstThrowFrameFlag(boolean flag) {
		this.firstThrowHasValueInFrameFlag = flag;
	}
	
	private void resetSecondThrowFrameFlag(boolean flag) {
		this.secondThrowHasValueInFrameFlag = flag;
	}
	
	public int getScore() {
		if(frames.size()>=10) {
			updateAllFrameScores();
			
		}else {
			System.out.println("Need more scores");
		}
		
		return this.frames.getLast().getScore();
	}
	
	public void updateAllFrameScores() {
		this.getFramesList().forEach(frame->{
			
			if(frame.getSecond()==10) {
				
				Frame temp = frame;
				int index = 0;
				while(temp !=null && temp.getSecond()==10) {
					temp = temp.getNextFrame();
					index++;
				}
				
				if(index>2) {
					int score = 30 + (frame.getPreviousFrame()!=null ? frame.getPreviousFrame().getScore() : 0);
					frame.setScore(score);
				}else {
					
					int score = index*10 + (temp!=null ? temp.getFirst() : 0) 
							+ (temp!=null ? temp.getSecond() : 0)
							+ (frame.getPreviousFrame()!=null ? frame.getPreviousFrame().getScore() : 0);
					frame.setScore(score);
				}
					
			}	
			else if(frame.getFirst()+frame.getSecond()==10 && frame.getThird()==0) {
				int score = 10 + (frame.getNextFrame()!=null ? frame.getNextFrame().getFirst() : 0) 
					+ (frame.getPreviousFrame()!=null ? frame.getPreviousFrame().getScore() : 0);
				frame.setScore(score);
				
			}
			else {
				int score = frame.getFirst()+frame.getSecond()+frame.getThird() 
					+ (frame.getPreviousFrame()!=null ? frame.getPreviousFrame().getScore() : 0);
				frame.setScore(score);
			}
		});
		
		
		
	}
	
	public LinkedList<Frame> getFramesList(){
		return this.frames;
	}
}
