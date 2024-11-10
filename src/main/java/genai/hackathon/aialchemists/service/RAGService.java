package genai.hackathon.aialchemists.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RAGService {

    @Autowired
    private LLMService llmService;

    public String generateRAGResponse(String query, List<String> contexts) {
        String prompt = "Context: " + String.join("\n", contexts) + "\nQuery: " + query + "\nAnswer:";
        return llmService.generateResponse(prompt);
    }
}
