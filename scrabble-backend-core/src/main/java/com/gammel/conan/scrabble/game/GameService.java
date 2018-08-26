package com.gammel.conan.scrabble.game;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.gammel.conan.scrabble.controllers.game.GameRequest;
import com.gammel.conan.scrabble.controllers.game.GameResponse;

public class GameService {

//	@Autowired
//	Database database;
	
	public GameResponse startGame(GameRequest request) {
		GameResponse response = new GameResponse();
		response.setID(UUID.randomUUID().toString());
		
		return response;
		
	}
}
