package genai.hackathon.aialchemists.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocumentEmbedding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String documentId;
    private String content;

    @ElementCollection
    @CollectionTable(name = "embedding_values")
    private List<Float> embedding;
}
