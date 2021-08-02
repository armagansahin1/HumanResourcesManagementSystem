package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {

		this.cityDao = cityDao;
	}
	@Override
	public Result add(City city) {
			
			city.setCityName(city.getCityName().toUpperCase().trim());
			city.setCountryName(city.getCountryName().toUpperCase().trim());
			
			var result = BusinessRules.Run(new Result[] {isCityExist(city)});
			if(result == null) {
				this.cityDao.save(city);
				return new SuccessResult("Eklendi"); 
			}
			
			
		
		return result;
	}
	

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}
	
	@Override
	public DataResult<List<City>> getAllByOrderByCityNameAsc() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.getAllByOrderByCityNameAsc());
	}
	
	private Result isCityExist(City city) {
		var result = this.cityDao.getByCityName(city.getCityName());
		if(result == null) {
			return new SuccessResult();
		}
		
		return new ErrorResult("Şehir ismi bulunmaktadır");
	}
	
}
