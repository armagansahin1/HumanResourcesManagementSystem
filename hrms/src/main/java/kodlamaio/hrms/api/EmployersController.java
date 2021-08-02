package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/Employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;
	
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	DataResult<List<Employer>> getAll(){
		
		return	this.employerService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return this.employerService.add(employerForRegisterDto);
	}
	
	@PostMapping("/setStatus")
	Result setAccountStatus(@RequestBody boolean status,@RequestBody int employerId) {
		return this.employerService.setAccountStatus(status, employerId);
	}
	
	@GetMapping("/getByAccountVerify")
	DataResult<List<Employer>> getByAccountVerify(@RequestParam boolean status){
		return this.employerService.getByAccountVerify(status);
	}
}
