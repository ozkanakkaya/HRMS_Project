package ozkanakkaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ozkanakkaya.hrms.business.abstracts.JobPositionService;
import ozkanakkaya.hrms.core.utilities.results.DataResult;
import ozkanakkaya.hrms.core.utilities.results.ErrorResult;
import ozkanakkaya.hrms.core.utilities.results.Result;
import ozkanakkaya.hrms.core.utilities.results.SuccessDataResult;
import ozkanakkaya.hrms.core.utilities.results.SuccessResult;
import ozkanakkaya.hrms.dataAccess.abstracts.JobPositionDao;
import ozkanakkaya.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İş pozisyonları listelendi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (this.jobPositionIsExist(jobPosition.getPositionName()).getData() != null) {//getData() metodunda veri var mı yok mu?
			return new ErrorResult("Bu pozisyon sistemde mevcuttur!");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi.");
	}

	private DataResult<JobPosition> jobPositionIsExist(String positionName) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPositionName(positionName));//eğer position name varsa DataResult daki getData() metoduna yerleştirir.
	}

}
