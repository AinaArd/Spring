package complicated.claimApp.repositories;

import complicated.claimApp.models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

    @Query(nativeQuery = true, value = "select * from claim inner join skill s on claim.id = s.claim_id where s.name = ?")
    List<Claim> search(String skill);
}
