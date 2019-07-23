package complicated.claimApp.controllers;

import complicated.claimApp.models.Claim;
import complicated.claimApp.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/search")
    public String getSearchPage() {
        return "search";
    }

    @PostMapping("/search")
    public String makeSearch(ModelMap model, @RequestParam(name = "skill") String skill){
        List<Claim> users = claimService.findUsers(skill);
        model.addAttribute("users", users);
        return "search";
    }
}
