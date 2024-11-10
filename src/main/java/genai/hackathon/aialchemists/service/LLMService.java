package genai.hackathon.aialchemists.service;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.openai.OpenAiLanguageModel;
import dev.langchain4j.model.output.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LLMService {

    @Autowired
    private OpenAiLanguageModel languageModel;

    public String generateResponse(String prompt) {
        Response<String> response = languageModel.generate(prompt);
        String responses = response.content();
        return responses;
    }

}
