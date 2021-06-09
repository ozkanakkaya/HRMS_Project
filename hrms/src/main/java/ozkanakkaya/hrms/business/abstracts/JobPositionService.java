package ozkanakkaya.hrms.business.abstracts;

import java.util.List;

import ozkanakkaya.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();
}
