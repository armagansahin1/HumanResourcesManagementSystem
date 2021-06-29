package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialAccountOfCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialAccountOfCandidateDao;
import kodlamaio.hrms.entities.concretes.SocialAccountOfCandidate;

@Service
public class SocialAccountOfCandidateManager implements SocialAccountOfCandidateService{
	
	private SocialAccountOfCandidateDao socialAccountOfCandidateDao;
	
	public SocialAccountOfCandidateManager(SocialAccountOfCandidateDao socialAccountOfCandidateDao) {
		this.socialAccountOfCandidateDao = socialAccountOfCandidateDao;
	}

	@Override
	public Result add(SocialAccountOfCandidate socialAccountOfCandidate) {
		this.socialAccountOfCandidateDao.save(socialAccountOfCandidate);
		return new SuccessResult("Sosyal medya hesapları eklendi");
	}

	@Override
	public DataResult<SocialAccountOfCandidate> getByCandidateId(int candidateId) {
		
		return new SuccessDataResult<SocialAccountOfCandidate>(this.socialAccountOfCandidateDao.getByCandidate_Id(candidateId));
	}
	
}
