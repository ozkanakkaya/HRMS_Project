package ozkanakkaya.hrms.business.abstracts;

import ozkanakkaya.hrms.core.utilities.results.DataResult;
import ozkanakkaya.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<User> checkEmail(String email);
}
