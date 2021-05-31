package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class FakeIdentityService implements IdentityVerificatonBase{

	@Override
	public boolean verify(User user) {
		if(user.getNationalityId().length() == 11) {
			return true;
		}
			return false;
		
	}

}
