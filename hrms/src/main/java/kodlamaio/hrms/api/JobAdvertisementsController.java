package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
   public DataResult<List<JobAdvertisement>> getAll(){
    	return this.jobAdvertisementService.getAll();
    }
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByAdvertismentStatusTrueOrderByRelaseDateDesc()")
	public DataResult<List<JobAdvertisement>> getByAdvertismentStatusTrueOrderByRelaseDateDesc(){
		return this.jobAdvertisementService.getByAdvertismentStatusTrueOrderByRelaseDateDesc();
	}
	
	@PostMapping("/changeStatus")
	public Result changeStatus(int id, boolean status) {
		return this.jobAdvertisementService.changeStatus(id, status);
	}
	
	@GetMapping("/findAllByOrderByRelaseDateDesc")
	public DataResult<List<JobAdvertisement>> findAllByOrderByRelaseDateDesc(){
		return this.jobAdvertisementService.findAllByOrderByRelaseDateDesc();
	}
}
