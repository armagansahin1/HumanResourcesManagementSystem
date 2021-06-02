package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageOfCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageOfCandidateDao;
import kodlamaio.hrms.entities.concretes.LanguageOfCandidate;

@Service
public class LanguageOfCandidateManager implements LanguageOfCandidateService{
	private LanguageOfCandidateDao languageOfCandidateDao;
	
	@Autowired
	public LanguageOfCandidateManager(LanguageOfCandidateDao languageOfCandidateDao) {
		this.languageOfCandidateDao = languageOfCandidateDao;
	}

	@Override
	public Result add(LanguageOfCandidate languageOfCandidate) {
		this.languageOfCandidateDao.save(languageOfCandidate);
		return new SuccessResult("Dil bilgisi eklendi");
	}
}
