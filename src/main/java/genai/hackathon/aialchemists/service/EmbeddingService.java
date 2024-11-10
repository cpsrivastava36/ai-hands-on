package genai.hackathon.aialchemists.service;



import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmbeddingService {

    @Autowired
    private EmbeddingModel embeddingModel;

    public List<Float> generateEmbedding(String text) {

        Response<Embedding> response = embeddingModel.embed(text);

        Embedding embedding = response.content();
        return embedding.vectorAsList();
    }
}
