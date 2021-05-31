package kodlamaio.hrms.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;

@RestController
@RequestMapping("/api/Companies")
public class CompaniesController {
	
	private CompanyService companyService;

	public CompaniesController(CompanyService companyService) {
		
		this.companyService = companyService;
	}
	
	@PostMapping
	public Result add (@RequestBody Company company) {
		return this.companyService.add(company);
	}
}
