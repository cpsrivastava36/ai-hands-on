package genai.hackathon.aialchemists.controller;

import genai.hackathon.aialchemists.service.EmbeddingService;
import genai.hackathon.aialchemists.service.RAGService;
import genai.hackathon.aialchemists.service.SimilaritySearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rag")
public class RAGController {

    private final EmbeddingService embeddingService;
    private final SimilaritySearchService searchService;
    private final RAGService ragService;

    public RAGController(EmbeddingService embeddingService, SimilaritySearchService searchService, RAGService ragService) {
        this.embeddingService = embeddingService;
        this.searchService = searchService;
        this.ragService = ragService;
    }

    @PostMapping("/query")
    public String getRAGResponse(@RequestBody String query) {
        List<Float> queryEmbedding = embeddingService.generateEmbedding(query);
        List<String> topDocuments = searchService.findTopKSimilar(queryEmbedding, 3)
                .stream().map(doc -> doc.getContent()).collect(Collectors.toList());
        return ragService.generateRAGResponse(query, topDocuments);
    }
}
