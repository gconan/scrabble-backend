package com.gammel.conan.scrabble.game;

import java.util.List;

public class Player {

	private String name;
	private List<LetterTile> tiles;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<LetterTile> getTiles() {
		return tiles;
	}
	
	public void setTiles(List<LetterTile> tiles) {
		this.tiles = tiles;
	}
}
