package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	
 DataResult<List<JobAdvertisement>> getAll();
 
 DataResult<List<JobAdvertisement>> getAll(int pageSize, int pageNo);
 
 DataResult<List<JobAdvertisement>> getByAdvertismentStatusTrueOrderByPublishDateDesc();
 
 DataResult<List<JobAdvertisement>> findAllByOrderByPublishDateDesc();
 
 DataResult<List<JobAdvertisement>> getByWorkType(String workType);
 
 Result add(JobAdvertisement jobAdvertisement);
 
 Result changeStatus(int id, boolean status);
}
