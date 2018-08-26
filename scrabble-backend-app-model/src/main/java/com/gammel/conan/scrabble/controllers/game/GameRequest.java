package com.gammel.conan.scrabble.controllers.game;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class GameRequest {

	@Min(value = 15)
	@Max(value = 100)
	private int boardSize;

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	
}
