package complicated.claimApp.repositories;

import complicated.claimApp.models.Skill;
import complicated.claimApp.services.SkillCountStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "    v.name AS name, COUNT(v) AS cnt " +
            "FROM " +
            "    skill v " +
            "GROUP BY " +
            "v.name order by cnt desc")
    List<SkillCountStatistics> findSkillCount();
}
