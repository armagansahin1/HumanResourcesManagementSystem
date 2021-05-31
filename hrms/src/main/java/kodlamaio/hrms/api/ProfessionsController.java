package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProfessionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Profession;

@RestController
@RequestMapping("/api/professions")
public class ProfessionsController {
	
	private ProfessionService professionService;
	
	@Autowired
	public ProfessionsController(ProfessionService professionService) {
		super();
		this.professionService = professionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Profession>> getAll(){
		
		return this.professionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Profession profession)
	{
		return this.professionService.add(profession);
	}
}
