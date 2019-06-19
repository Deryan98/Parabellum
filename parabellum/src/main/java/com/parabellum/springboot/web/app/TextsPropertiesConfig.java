package com.parabellum.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:texts.properties.urls"),
	@PropertySource("classpath:texts.properties.controllers.indexcontroller")
})
public class TextsPropertiesConfig {
	
}
