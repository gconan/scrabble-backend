package com.gammel.conan.scrabble.controllers.game;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gammel.conan.scrabble.exceptions.ScrabbleExceptionHandler;
import com.gammel.conan.scrabble.game.GameService;

public class GameControllerTest {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final String gameId = "gameId";
	
	@InjectMocks
	private GameController objectUnderTest;
	
	@Mock
	private GameService gameServiceMock;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(objectUnderTest).setControllerAdvice(new ScrabbleExceptionHandler()).build();
	}

	@Test
	public void test() throws JsonProcessingException, Exception {
		GameRequest gameRequest = new GameRequest();
		gameRequest.setBoardSize(15);
		
		
		GameResponse gameResponse = new GameResponse();
		gameResponse.setID(gameId);
		
		Mockito.when(gameServiceMock.startGame(gameRequest)).thenReturn(gameResponse);
		
		MvcResult mvcResult = mockMvc.perform(post("/v1/game")
				.content(mapper.writeValueAsBytes(gameRequest))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(header().string("Location", "http://localhost/v1/game/" + gameId))
				.andReturn();
		
		
	}

}
