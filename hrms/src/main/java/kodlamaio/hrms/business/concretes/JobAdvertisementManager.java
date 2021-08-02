package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	private JobAdvertisementDao jobAdvertisementDao;

	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		setDefaults(jobAdvertisement);

		this.jobAdvertisementDao.save(jobAdvertisement);
		
		return new SuccessResult("Eklendi");
	}
	
	
	
	@Override
	public Result changeStatus(int id, boolean status) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id).get();
		jobAdvertisement.setAdvertismentStatus(status);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan aktif durumu güncellendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByAdvertismentStatusTrueOrderByPublishDateDesc() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAdvertismentStatusTrueOrderByPublishDateDesc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByOrderByPublishDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAllByOrderByPublishDateDesc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageSize, int pageNo) {
		Pageable pageable = PageRequest.of(pageNo-1,pageSize);
		int a = this.jobAdvertisementDao.findAll(pageable).getTotalPages();
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(pageable).getContent(),String.valueOf(a));
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByWorkType(String workType) {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByWorkTypeAndAdvertismentStatusTrue(workType));
	}

	
	private JobAdvertisement setDefaults(JobAdvertisement jobAdvertisement) {
		Date date = new Date();
		jobAdvertisement.setPublishDate(date);
		jobAdvertisement.setAdvertismentStatus(false);
		return jobAdvertisement;
	}

	

}
