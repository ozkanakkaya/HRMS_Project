package ozkanakkaya.hrms.core.utilities.adapters;

import ozkanakkaya.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {
	
	boolean checkIfRealPerson(JobSeeker jobSeeker);
	
}
