package kodlamaio.hrms.core.helpers.emailTools;

import org.springframework.stereotype.Service;

@Service
public class FakeMailVerification implements EmailVerificationBase{

	@Override
	public boolean sendMail(String Email) {
		
		return true;
	}

}
