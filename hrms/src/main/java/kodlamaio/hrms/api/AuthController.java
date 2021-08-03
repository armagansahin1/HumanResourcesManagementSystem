package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/Auth")
@CrossOrigin
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {

		this.authService = authService;
	}
	
	@PostMapping("/registerForEmployer")
	public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		var result = this.authService.registerForEmployer(employerForRegisterDto);
		return result;
	}
	
	@PostMapping("/registerForCandidate")
	public Result registerForCandidate(@RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		var result = this.authService.registerForCandidate(candidateForRegisterDto);
		return result;
	}
}
