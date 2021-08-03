package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private UserService userService ;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserService userService) {
		
		this.candidateDao = candidateDao;
		this.userService = userService ;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public Result add(Candidate candidate) {
	
		
		var userServiceResult = this.userService.add(candidate);
		if(userServiceResult.isSuccess()) {
			this.candidateDao.save(candidate);
			return new SuccessResult("İş Arayan Eklendi");
		}
		else {
			return userServiceResult;
		}
		

	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId).get());
	}





}
