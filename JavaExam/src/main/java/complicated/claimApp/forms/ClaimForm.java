package complicated.claimApp.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimForm {
    private String surname;
    private String email;
    private String skill1;
    private String skill2;
    private String skill3;
    private String skill4;
    private String skill5;
}
