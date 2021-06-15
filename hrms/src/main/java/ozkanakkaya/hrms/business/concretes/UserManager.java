package ozkanakkaya.hrms.business.concretes;

import org.springframework.stereotype.Service;

import ozkanakkaya.hrms.business.abstracts.UserService;
import ozkanakkaya.hrms.core.utilities.results.DataResult;
import ozkanakkaya.hrms.core.utilities.results.SuccessDataResult;
import ozkanakkaya.hrms.dataAccess.abstracts.UserDao;
import ozkanakkaya.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public DataResult<User> checkEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}
	
}
