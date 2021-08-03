package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@Service
public class AuthManager implements AuthService{
	
	private EmployerService employerService;
	private CandidateService candidateService;
	
	@Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
	}
	
	@Override
	public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {
		
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
		
		return this.employerService.add(employer);
	}

	@Override
	public Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto) {
		
		Candidate candidate = new Candidate();
		candidate.setFirstName(candidateForRegisterDto.getFirstName().toUpperCase());
		candidate.setLastName(candidateForRegisterDto.getLastName().toUpperCase());
		candidate.setNationalityId(candidateForRegisterDto.getNationalityId());
		candidate.setDateOfBirth(candidateForRegisterDto.getDateOfBirth());
		candidate.setEmail(candidateForRegisterDto.getEmail());
		candidate.setPassword(candidateForRegisterDto.getPassword());
		candidate.setProfession(candidateForRegisterDto.getProfession().toUpperCase());
		
		return this.candidateService.add(candidate);
	}
	
}
