package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrms.entities.concretes.WorkTime;

@Service
public class WorkTimeManager implements WorkTimeService{
	
	public WorkTimeDao workTimeDao;
	
	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		this.workTimeDao = workTimeDao;
	}
	
	@Override
	public Result add(WorkTime workTime) {
		this.workTimeDao.save(workTime);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkTime>> getAll() {
		return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.findAll());
	}

}
