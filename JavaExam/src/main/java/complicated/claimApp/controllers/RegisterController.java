package complicated.claimApp.controllers;

import complicated.claimApp.forms.ClaimForm;
import complicated.claimApp.models.Claim;
import complicated.claimApp.services.ClaimService;
import complicated.claimApp.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final ClaimService service;

    @Autowired
    private SkillService skillService;

    @Autowired
    public RegisterController(ClaimService service) {
        this.service = service;
    }

    @GetMapping(path = "/register")
    public String getRegisterPage() {
        return "register";
    }


    @PostMapping("/register")
    public String makeClaim(ClaimForm claimForm, ModelMap modelMap) {
        Claim claim = Claim.builder()
                .email(claimForm.getEmail())
                .surname(claimForm.getSurname())
                .build();
        service.addClaim(claim);
        skillService.addSkills(claimForm, claim);
        return "redirect:/register";
    }

}
