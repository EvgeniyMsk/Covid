package covid.repository;

import covid.entity.CovidInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidInfoRepository extends JpaRepository<CovidInfo, Long> {
    CovidInfo findByDepartment(int department);
}
