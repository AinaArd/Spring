package complicated.claimApp.services;

import complicated.claimApp.forms.ClaimForm;
import complicated.claimApp.models.Claim;
import complicated.claimApp.models.Skill;
import complicated.claimApp.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void addSkills(ClaimForm claimForm, Claim claim) {
        List<String> skills = new ArrayList<>();
        skills.add(claimForm.getSkill1());
        skills.add(claimForm.getSkill2());
        skills.add(claimForm.getSkill3());
        skills.add(claimForm.getSkill4());
        skills.add(claimForm.getSkill5());
        for (String skill : skills) {
            if (!skill.equals("")) {
                Skill newSkill = Skill.builder()
                        .name(skill)
                        .claim(claim)
                        .build();
                skillRepository.save(newSkill);
            }
        }
    }

    @Override
    public Map<Integer, String> makeStatistics() {
        Map<Integer, String> results = new HashMap<>();
        List<Skill> skills = skillRepository.findAll();
        for(Skill skill : skills){
//            results.put(skillRepository.makeStatistics(skill.getName()), skill.getName());
        }
        return results;
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

}
