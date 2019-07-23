package complicated.claimApp.services;

import complicated.claimApp.models.Claim;
import complicated.claimApp.repositories.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public void addClaim(Claim claim) {
        claimRepository.save(claim);
    }

    @Override
    public List<Claim> findAll() {
        return claimRepository.findAll();
    }

    @Override
    public List<Claim> findUsers(String skill) {
        return claimRepository.search(skill);
    }
}
