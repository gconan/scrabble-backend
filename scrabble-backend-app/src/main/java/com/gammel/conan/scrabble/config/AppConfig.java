package com.gammel.conan.scrabble.config;

import org.apache.catalina.Context;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CoreConfig.class)
public class AppConfig {

	
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addContextCustomizers(new TomcatContextCustomizer() {
			
			//dont lose protocol when trailing slash is appeneded to url
			
			@Override
			public void customize(Context context) {
				context.setUseRelativeRedirects(true);
				
			}
		});
		return tomcat;
	}
}
