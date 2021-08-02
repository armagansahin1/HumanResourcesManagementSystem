package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/workTypes")
@CrossOrigin
public class WorkTypesController {
	
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		this.workTypeService = workTypeService;
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody WorkType workType) {
		return this.workTypeService.add(workType);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}
}
