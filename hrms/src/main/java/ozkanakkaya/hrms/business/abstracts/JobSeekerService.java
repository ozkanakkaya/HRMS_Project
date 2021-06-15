package ozkanakkaya.hrms.business.abstracts;

import java.util.List;

import ozkanakkaya.hrms.core.utilities.results.DataResult;
import ozkanakkaya.hrms.core.utilities.results.Result;
import ozkanakkaya.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSekeer);
}
