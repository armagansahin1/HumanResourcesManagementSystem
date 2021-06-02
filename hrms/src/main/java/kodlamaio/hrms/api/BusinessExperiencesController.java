package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.BusinessExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.BusinessExperience;

@RestController
@RequestMapping("/api/BusinessExperiences")
public class BusinessExperiencesController {
	
	private BusinessExperienceService businessExperienceService;
	
	@Autowired
	public BusinessExperiencesController(BusinessExperienceService businessExperienceService) {
		this.businessExperienceService = businessExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody BusinessExperience businessExperience) {
		return this.businessExperienceService.add(businessExperience);
	}
	
	@GetMapping("/getall")
	public DataResult<List<BusinessExperience>> getAll(){
		return this.businessExperienceService.getAll();
	}
	
	@GetMapping("/getByCandidateIdOrderByOutDateDesc")
	public DataResult<List<BusinessExperience>> getByCandidateIdOrderBygraduationDesc(@RequestParam int candidateId){
		return this.businessExperienceService.getByCandidateIdOrderByOutDateDesc(candidateId);
	}
}
