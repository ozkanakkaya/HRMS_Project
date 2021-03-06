package ozkanakkaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ozkanakkaya.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

	JobPosition findByPositionName(String positionName);

}
