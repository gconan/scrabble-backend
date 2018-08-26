package com.gammel.conan.scrabble.controllers.game;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gammel.conan.scrabble.ErrorResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@Api(tags = "Games")
@RestController
@RequestMapping("/v1/game")
public class GameController {

	private static final String CREATED_NEW_GAME_RESPONSE =  "Game Created";
	private static final String POST_400_RESPONSE_MESSAGE = "The request payload was invalid";
	private static final String POST_500_RESPONSE_MESSAGE = "Internal error occurred";

	//CREATE
	@ApiOperation(value = "Start a new game")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = CREATED_NEW_GAME_RESPONSE, response = GameResponse.class, responseHeaders = @ResponseHeader(name = HttpHeaders.LOCATION, description = "Location of created game")),
			@ApiResponse(code = 400, message = POST_400_RESPONSE_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = POST_500_RESPONSE_MESSAGE, response = ErrorResponse.class) })
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameResponse> startANewGame(
			final HttpServletRequest request,
			@ApiParam(name = "request", value = "New Game Properties", required = true) @Valid @RequestBody final GameRequest gameRequest){
		GameResponse gameResponse = new GameResponse();

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(gameResponse.getID()).toUri();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add(HttpHeaders.LOCATION, location.toString());
		return new ResponseEntity<>(gameResponse, responseHeaders, HttpStatus.CREATED);
	}
}
