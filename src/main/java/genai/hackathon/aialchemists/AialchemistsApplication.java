package genai.hackathon.aialchemists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"genai.hackathon.aialchemists.config",         // Configuration classes
		"genai.hackathon.aialchemists.controller",     // REST controllers
		"genai.hackathon.aialchemists.service",        // Service layer
		"dev.langchain4j"             // LangChain4j components
})

public class AialchemistsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AialchemistsApplication.class, args);
	}

}
