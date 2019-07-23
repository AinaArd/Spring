package complicated.postApp.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post", schema = "public")
@ToString(exclude = {"answers", "replyTo"})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;
    private String text;
    private Date date;
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "reply_to_id")
    private Post replyTo;

    @OneToMany(mappedBy = "replyTo")
    private List<Post> answers;
}
