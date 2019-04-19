package app.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "participant")
public class Participant {
    private Long id;
    private String name;
    private String city;
    private String email;

}
