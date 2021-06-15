package ozkanakkaya.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ozkanakkaya.hrms.business.abstracts.JobSeekerService;
import ozkanakkaya.hrms.business.abstracts.UserService;
import ozkanakkaya.hrms.core.abstracts.EmailCheckService;
import ozkanakkaya.hrms.core.utilities.adapters.MernisCheckService;
import ozkanakkaya.hrms.core.utilities.results.DataResult;
import ozkanakkaya.hrms.core.utilities.results.ErrorResult;
import ozkanakkaya.hrms.core.utilities.results.Result;
import ozkanakkaya.hrms.core.utilities.results.SuccessDataResult;
import ozkanakkaya.hrms.core.utilities.results.SuccessResult;
import ozkanakkaya.hrms.dataAccess.abstracts.JobSeekerDao;
import ozkanakkaya.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	JobSeekerDao jobSeekerDao;
	UserService userService;
	MernisCheckService mernisCheckService;
	EmailCheckService emailCheckService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService, MernisCheckService mernisCheckService,
			EmailCheckService emailCheckService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
		this.mernisCheckService = mernisCheckService;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
	}

	private DataResult<List<JobSeeker>> nationalityIdExist(String nationalityId) {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findByNationalityId(nationalityId));
	}

	// Zorunlu alanlar
	private boolean mandatoryFields(JobSeeker jobSeeker) {
		if (Objects.isNull(jobSeeker.getNationalityId()) || Objects.isNull(jobSeeker.getFirstName())
				|| Objects.isNull(jobSeeker.getLastName()) || Objects.isNull(jobSeeker.getDateOfBirth())
				|| Objects.isNull(jobSeeker.getEmail()) || Objects.isNull(jobSeeker.getPhoneNumber())
				|| Objects.isNull(jobSeeker.getPassword()) || Objects.isNull(jobSeeker.getPasswordRepeat())) {
			return false;
		}

		return true;
	}

	@Override
	public Result add(JobSeeker jobSekeer) {
		if (!mandatoryFields(jobSekeer)) {
			return new ErrorResult("Lütfen gerekli tüm alanları doldurunuz!");
		}
		if (!mernisCheckService.checkIfRealPerson(jobSekeer)) {
			return new ErrorResult("Geçerli bir kişi değil!");
		}
		
		if (!emailCheckService.emailCheck(jobSekeer.getEmail())) {
			return new ErrorResult("Geçerli bir e-posta adresi giriniz!");
		}

		if ((this.userService.checkEmail(jobSekeer.getEmail()).getData() != null)) {
			return new ErrorResult("E-Posta adresi zaten sistemde mevcuttur!");
		}

		if (this.nationalityIdExist(jobSekeer.getNationalityId()).getData() != null) {// getData() metodunda veri var
																						// mı? // yok mu?
			return new ErrorResult("TC. Kimlik No zaten sistemde mevcuttur!");
		}

		this.jobSeekerDao.save(jobSekeer);
		return new SuccessResult("İş arayan kişisi sisteme kaydedildi.");
	}

}
