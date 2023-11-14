package com.bowling.classes;

import java.util.Arrays;

public class BoardGameTest {

	public static void main(String[] args) {
		
		int[] pins = {10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9, 0, 8, 2, 9, 1, 10};
		
		BoardGame board = new BoardGame();		
		Arrays.stream(pins).forEach(i->board.throwBall(i));
		
		System.out.println("The Final Score is "+board.getScore());
		
		
		System.out.println("\n"+"Below are the frames:");
		board.getFramesList().forEach(frame->System.out.println(frame+"\n"));
	}

}
