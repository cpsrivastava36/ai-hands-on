package genai.hackathon.aialchemists.service;

import genai.hackathon.aialchemists.model.DocumentEmbedding;
import genai.hackathon.aialchemists.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SimilaritySearchService {

    private final DocumentRepository repository;

    public SimilaritySearchService(DocumentRepository repository) {
        this.repository = repository;
    }

    public List<DocumentEmbedding> findTopKSimilar(List<Float> queryEmbedding, int k) {
        return repository.findAll().stream()
                .sorted(Comparator.comparingDouble(doc -> cosineSimilarity(queryEmbedding, doc.getEmbedding())))
                .limit(k)
                .toList();
    }


    private double cosineSimilarity(List<Float> vectorA, List<Float> vectorB) {
        float dotProduct = 0f, normA = 0f, normB = 0f;
        for (int i = 0; i < vectorA.size(); i++) {
            dotProduct += vectorA.get(i) * vectorB.get(i);
            normA += vectorA.get(i) * vectorA.get(i);
            normB += vectorB.get(i) * vectorB.get(i);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

}
