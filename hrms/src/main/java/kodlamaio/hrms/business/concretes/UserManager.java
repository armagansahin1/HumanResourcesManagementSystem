package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.core.adapters.IdentityVerificatonBase;
import kodlamaio.hrms.core.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.helpers.emailTools.EmailVerificationBase;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.business.Validators.Regex.RegexValidation;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	private IdentityVerificatonBase identityService;
	private EmailVerificationBase emailVerification;
	@Autowired
	public UserManager(UserDao userDao,IdentityVerificatonBase identityService,EmailVerificationBase emailVerification) {
		super();
		this.userDao = userDao;
		this.identityService = identityService;
		this.emailVerification = emailVerification;
		
	}
	
	
	
	@Override
	public Result add(User user){
		
		
		var result = BusinessRules.Run(new Result[] {validEmailControl(user.getEmail()),isNationalIdExists(user.getNationalityId()),isEmailExists(user.getEmail()),
				checkPerson(user), verifyAccountWithEmail(user.getEmail())});
		if(result == null) {
			this.userDao.save(user);
			return new SuccessResult("Kullanıcı Eklendi");
		}
		return result;
		
	}



	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}
	
	@Override
	public DataResult<User> getById(int id) {
		
		
		return new SuccessDataResult<User>(this.userDao.findById(id).get());
		
	}
	


	
	private Result checkPerson(User user) {
		if(identityService.verify(user) == true) {
			return new SuccessResult();
		}
		return new ErrorResult("Kimlik Bilgileriniz Hatalı");
	}
	
	private Result verifyAccountWithEmail(String email) {
		if(emailVerification.sendMail(email) == true) {
			return new SuccessResult();
		}
		return new ErrorResult("Email Doğrulanamadı");
	}
	
	private Result isEmailExists(String email) {
		if(userDao.findByEmail(email) == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu mail adresi sistemde kayıtlı");
	}
	
	private Result isNationalIdExists(String nationalId) {
		if(userDao.findByNationalityId(nationalId) == null) {
			return new SuccessResult();
		}
		
		return new ErrorResult("Bu kimlik numarası ile sistemde kayıtlı kişi bulunmaktadır");
	}
	
	private Result validEmailControl(String email) {
		if(RegexValidation.emailValidate(email)) {
			return new SuccessResult();
		}
		
		return new ErrorResult("Geçerli bir mail adresi giriniz.");

	}



	




	
	
	
	
	
	

}
