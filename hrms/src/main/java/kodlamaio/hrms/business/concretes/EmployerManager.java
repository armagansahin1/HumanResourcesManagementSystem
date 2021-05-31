package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
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
import kodlamaio.hrms.entities.concretes.User;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;
	private CompanyService companyService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService,CompanyService companyService) {
		
		this.employerDao = employerDao;
		this.userService = userService;
		this.companyService = companyService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {
		
		employer.getCompany().setWebsite(addWWW(employer.getCompany().getWebsite()));
		employer.setAccountVerify(false);
		//var result = BusinessRules.Run(new Result[]{checkEmailForDomain(employer)});
		Result result = null;
		if(result == null) {
			
				this.employerDao.save(employer);
				return new SuccessResult("Eklendi");
			
		
		}
		
		return result;
		
	}
	
	private Result checkEmailForDomain(Employer employer) {
		if(employer.getUser().getEmail().trim().contains(employer.getCompany().getWebsite().trim()) == true) {
			return new SuccessResult();
		}
		
		return new ErrorResult("Email adresiniz Websitenizle uyumlu olmalı " + employer.getCompany().getWebsite() + " " + employer.getUser().getEmail());
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
