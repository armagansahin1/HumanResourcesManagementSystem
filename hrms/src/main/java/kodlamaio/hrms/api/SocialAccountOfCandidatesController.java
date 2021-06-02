package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageOfCandidateService;
import kodlamaio.hrms.business.abstracts.SocialAccountOfCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageOfCandidate;
import kodlamaio.hrms.entities.concretes.SocialAccountOfCandidate;

@RestController
@RequestMapping("/api/SocialAccountOfCandidate")
public class SocialAccountOfCandidatesController {
	
	private SocialAccountOfCandidateService socialAccountOfCandidateService;
	
	@Autowired
	public SocialAccountOfCandidatesController(SocialAccountOfCandidateService socialAccountOfCandidateService) {
		this.socialAccountOfCandidateService = socialAccountOfCandidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialAccountOfCandidate socialAccountOfCandidate) {
		return this.socialAccountOfCandidateService.add(socialAccountOfCandidate);
	}
}