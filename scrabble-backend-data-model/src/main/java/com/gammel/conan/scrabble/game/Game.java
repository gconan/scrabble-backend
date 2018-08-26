package com.gammel.conan.scrabble.game;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Game {
	
	private Set<Player> players;
	private int boardSize;
	private String playerNameWhosTurnItIs;
	private List<LetterTile> tiles;
	
	public Game() {
		players = new TreeSet<>(); //order is guaranteed
	}
	
	
	public Set<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	public String getPlayerNameWhosTurnItIs() {
		return playerNameWhosTurnItIs;
	}
	
	public void setPlayerNameWhosTurnItIs(String playerNameWhosTurnItIs) {
		this.playerNameWhosTurnItIs = playerNameWhosTurnItIs;
	}
	
	public List<LetterTile> getTiles() {
		return tiles;
	}
	
	public void setTiles(List<LetterTile> tiles) {
		this.tiles = tiles;
	}
	

}
