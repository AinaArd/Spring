package complicated.claimApp.services;

import complicated.claimApp.models.Claim;

import java.util.List;

public interface ClaimService {
    void addClaim(Claim claim);

    List<Claim> findAll();

    List<Claim> findUsers(String skill);
}
