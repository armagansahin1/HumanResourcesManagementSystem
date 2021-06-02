package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageOfCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageOfCandidate;

@RestController
@RequestMapping("/api/LanguageOfCandidate")
public class LanguageOfCandidatesController {
	
	private LanguageOfCandidateService languageOfCandidateService;
	
	@Autowired
	public LanguageOfCandidatesController(LanguageOfCandidateService languageOfCandidateService) {
		this.languageOfCandidateService = languageOfCandidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LanguageOfCandidate languageOfCandidate) {
		return this.languageOfCandidateService.add(languageOfCandidate);
	}
}
