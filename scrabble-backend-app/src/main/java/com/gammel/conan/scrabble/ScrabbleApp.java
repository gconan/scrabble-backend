package com.gammel.conan.scrabble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gammel.conan.scrabble"})
@EnableAutoConfiguration
public class ScrabbleApp {
	
    public static void main( String[] args ) {
        checkEnvVars();
        SpringApplication.run(ScrabbleApp.class, args);
    }
    
    private static void checkEnvVars() {
    	
    }
}
