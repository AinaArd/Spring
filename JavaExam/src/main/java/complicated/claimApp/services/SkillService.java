package complicated.claimApp.services;

import complicated.claimApp.forms.ClaimForm;
import complicated.claimApp.models.Claim;
import complicated.claimApp.models.Skill;

import java.util.List;
import java.util.Map;

public interface SkillService {
    void addSkills(ClaimForm claimForm, Claim claim);

    Map<Integer, String> makeStatistics();

    List<Skill> findAll();
}
