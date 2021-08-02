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
	
	@GetMapping("/getByAdvertismentStatusTrueOrderByPublishDateDesc")
	public DataResult<List<JobAdvertisement>> getByAdvertismentStatusTrueOrderByPublishDateDesc(){
		return this.jobAdvertisementService.getByAdvertismentStatusTrueOrderByPublishDateDesc();
	}
	
	@PostMapping("/changeStatus")
	public Result changeStatus(int id, boolean status) {
		return this.jobAdvertisementService.changeStatus(id, status);
	}
	
	@GetMapping("/findAllByOrderByPublishDateDesc")
	public DataResult<List<JobAdvertisement>> findAllByOrderByPublishDateDesc(){
		return this.jobAdvertisementService.findAllByOrderByPublishDateDesc();
	}
	
	@GetMapping("/getPageFormat")
	public DataResult<List<JobAdvertisement>> getPageFormat(int pageSize,int pageNo){
		return this.jobAdvertisementService.getAll(pageSize, pageNo);
	}
	
	@GetMapping("/getByWorkType")
	public DataResult<List<JobAdvertisement>> getByWorkType(String workType) {
		
		return this.jobAdvertisementService.getByWorkType(workType);
	}

}
