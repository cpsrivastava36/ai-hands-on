package genai.hackathon.aialchemists.config;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.language.LanguageModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.model.openai.OpenAiLanguageModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LangChainConfig {

    @Bean
    public EmbeddingModel embeddingModel() {
        // Configure the OpenAI Embedding Model
        return OpenAiEmbeddingModel.builder()
                //.apiKey("{0}")
                .modelName("text-embedding-ada-002")
                .build();
    }

    @Bean
    public OpenAiLanguageModel openAiLanguageModel() {
        return OpenAiLanguageModel.builder()
                //.apiKey("{0}")
                .modelName("gpt-4")
                .temperature(0.4)
                .build();
    }
    @Bean
    public LanguageModel languageModel(OpenAiLanguageModel openAiLanguageModel) {
        return openAiLanguageModel;
    }
}
