package com.gammel.conan.scrabble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gammel.conan.scrabble.utils.EnvVarUtil;

@SpringBootApplication
@ComponentScan({"com.gammel.conan.scrabble"})
@EnableAutoConfiguration
public class ScrabbleApp {
	
    public static void main( String[] args ) {
        checkEnvVars();
        SpringApplication.run(ScrabbleApp.class, args);
    }
    
    private static void checkEnvVars() {
    	
    	Set<String> requiredEnvVars = new TreeSet<String>(Arrays.asList(
    			"FILE_SYSTEM_PATH"
    			));
    	
    	List<String> missingEnvVars = new ArrayList<>();
    	for(String key : requiredEnvVars) {
    		if(EnvVarUtil.getValue(key) == null) {
    			missingEnvVars.add(key);
    		}
    	}
    	
    	if(!missingEnvVars.isEmpty()) {
    		throw new RuntimeException("Missing required variables: " + String.join(", ", missingEnvVars));
    	}
    }
}
