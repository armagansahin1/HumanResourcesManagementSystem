package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService{
	private CompanyDao companyDao;
	
	@Autowired
	public CompanyManager(CompanyDao companyDao) {

		this.companyDao = companyDao;
	}
	@Override
	public Result add(Company company) {
		
		this.companyDao.save(company);
		return new SuccessResult("Eklendi");
	}

}
