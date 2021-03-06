package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialAccountOfCandidate;

public interface SocialAccountOfCandidateService {
	Result add(SocialAccountOfCandidate socialAccountOfCandidate);
	DataResult<SocialAccountOfCandidate> getByCandidateId(int candidateId);
}
