package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;



@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;

	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService) {
		
		this.employerDao = employerDao;
		this.userService = userService;

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(EmployerForRegisterDto employerForRegisterDto){
		
		employerForRegisterDto.setWebsite(addWWW(employerForRegisterDto.getWebsite()));

		var result = BusinessRules.Run(new Result[]{checkEmailForDomain(employerForRegisterDto)});
		
		if(result == null) {

				Employer employer = new Employer();
				employer.setFirstName(employerForRegisterDto.getFirstName().toUpperCase());
				employer.setLastName(employerForRegisterDto.getLastName().toUpperCase());
				employer.setEmail(employerForRegisterDto.getEmail());
				employer.setNationalityId(employerForRegisterDto.getNationalityId());
				employer.setDateOfBirth(employerForRegisterDto.getDateOfBirth());
				employer.setPassword(employerForRegisterDto.getPassword());
				employer.setPhone(employerForRegisterDto.getPhone());
				employer.setCompanyName(employerForRegisterDto.getCompanyName().toUpperCase());
				employer.setWebsite(employerForRegisterDto.getWebsite());
				employer.setAccountVerify(true);
				
				var userServiceResult = this.userService.add(employer);
				if(userServiceResult.isSuccess()) {
					this.employerDao.save(employer);
					return new SuccessResult("İş veren eklendi");
				}
				
				else {
					return userServiceResult;
				}
				
		}
		
		return result;
		
	}
	
	private Result checkEmailForDomain(EmployerForRegisterDto employerForRegisterDto) {
		String webDomain = employerForRegisterDto.getWebsite().replace("www.", "");
		if(employerForRegisterDto.getEmail().contains(webDomain)) {
			return new SuccessResult();
		}
		return new ErrorResult("Email adresinizle web sayfası eşleşmiyor");
	}
	
	private String addWWW(String website) {
		if(website.contains("www.")) {
			return website;
		}
		
		return "www."+website;
	}

	@Override
	public Result setAccountStatus(boolean status, int employerId) {
		Employer employer = this.employerDao.findById(employerId).get();
		employer.setAccountVerify(status);
		this.employerDao.save(employer);
		
		return new SuccessResult("İş arayan hesap onayı güncellendi");
	}

	@Override
	public DataResult<List<Employer>> getByAccountVerify(boolean status) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByAccountVerify(status));
	}

}
