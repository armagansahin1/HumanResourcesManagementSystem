package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProfessionService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProfessionDao;
import kodlamaio.hrms.entities.concretes.Profession;

@Service
public class ProfessionManager implements ProfessionService{
  private ProfessionDao professionDao;

  @Autowired
  public ProfessionManager(ProfessionDao professionDao) {
	super();
	this.professionDao = professionDao;
  }

  	@Override
	public DataResult<List<Profession>> getAll() {
	
	return new SuccessDataResult<List<Profession>>(this.professionDao.findAll());
	}

	@Override
	public Result add(Profession profession) {
		var result= BusinessRules.Run(new Result[] {isProfessionExists(profession.getProfessionName())});
		if(result == null) {
			this.professionDao.save(profession);
			return new SuccessResult("Eklendi");
		}
		return result;
	}
	
	private Result isProfessionExists(String professionName) {
		if(this.professionDao.getByProfessionName(professionName).isEmpty()) {
			return new SuccessResult();
		}
		return new ErrorResult("Meslek adı bulunmaktadır");
	}




}
