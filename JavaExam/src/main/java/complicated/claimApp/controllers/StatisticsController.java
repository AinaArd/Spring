package complicated.claimApp.controllers;

import complicated.claimApp.repositories.SkillRepository;
import complicated.claimApp.services.SkillCountStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatisticsController {

    @Autowired
   private SkillRepository skillRepository;

    @GetMapping("/statistics")
    public String getStatistics(ModelMap model){
        List<SkillCountStatistics> results = skillRepository.findSkillCount();
        model.addAttribute("results", results);
        return "statistics";
    }
}
