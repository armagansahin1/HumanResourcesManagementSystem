package kodlamaio.hrms.business.concretes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private JobAdvertisement setDefaults(JobAdvertisement jobAdvertisement) {
		Date date = new Date();
		jobAdvertisement.setRelaseDate(date);
		jobAdvertisement.setAdvertismentStatus(true);
		return jobAdvertisement;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByOrderByRelaseDateDesc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAdvertismentStatusTrueOrderByRelaseDateDesc());
	}

	@Override
	public Result changeStatus(int id, boolean status) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id).get();
		jobAdvertisement.setAdvertismentStatus(status);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan aktif durumu güncellendi");
	}

}