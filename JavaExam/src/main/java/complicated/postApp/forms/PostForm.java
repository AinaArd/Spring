package complicated.postApp.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostForm {
    private Long id;
    private String theme;
    private String text;
    private String date;
}
