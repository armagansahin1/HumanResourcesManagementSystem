package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.BusinessExperienceDao;
import kodlamaio.hrms.entities.concretes.BusinessExperience;

@Service
public class BusinessExperienceManager implements BusinessExperienceService{
	
	private BusinessExperienceDao businessExperienceDao;

@Autowired
public BusinessExperienceManager(BusinessExperienceDao businessExperienceDao) {
		
		this.businessExperienceDao = businessExperienceDao;

	}

	@Override
	public DataResult<List<BusinessExperience>> getAll() {
		return new SuccessDataResult<List<BusinessExperience>>(this.businessExperienceDao.findAll());
	}

	@Override
	public Result add(BusinessExperience businessExperience) {
		
		this.businessExperienceDao.save(businessExperience);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<BusinessExperience>> getByCandidateIdOrderByOutDateDesc(int candidateId) {
		return new SuccessDataResult<List<BusinessExperience>>(this.businessExperienceDao.getByCandidate_IdOrderByOutDateDesc(candidateId));
	}
}
