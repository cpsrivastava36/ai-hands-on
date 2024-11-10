package genai.hackathon.aialchemists.repository;

import genai.hackathon.aialchemists.model.DocumentEmbedding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEmbedding, Long> {
}
