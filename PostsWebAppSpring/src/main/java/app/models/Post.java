package app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "post")
public class Post {
    private Long id;
    private String text;
    private Long author;

    public Post(String text, Long author) {
        this.text = text;
        this.author = author;
    }
}
