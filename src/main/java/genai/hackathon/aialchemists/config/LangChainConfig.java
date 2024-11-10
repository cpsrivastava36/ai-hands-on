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
                .apiKey("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")
                .modelName("text-embedding-ada-002")
                .build();
    }

    @Bean
    public OpenAiLanguageModel openAiLanguageModel() {
        return OpenAiLanguageModel.builder()
                .apiKey("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")
                .modelName("gpt-4")
                .temperature(0.4)
                .build();
    }
    @Bean
    public LanguageModel languageModel(OpenAiLanguageModel openAiLanguageModel) {
        return openAiLanguageModel;
    }
}
