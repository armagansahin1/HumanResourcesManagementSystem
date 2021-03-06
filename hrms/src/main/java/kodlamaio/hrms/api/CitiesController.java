package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/Cities")
@CrossOrigin
public class CitiesController {
	private CityService citySerivce;
	
	@Autowired
	public CitiesController(CityService citySerivce) {
		super();
		this.citySerivce = citySerivce;
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody City city) {
		return this.citySerivce.add(city);
	}
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll(){
		return this.citySerivce.getAll();
	}
	
	@GetMapping("/getAllByOrderByCityNameAsc")
	public DataResult<List<City>> getAllOrderByCityNameDesc(){
		return this.citySerivce.getAllByOrderByCityNameAsc();
	}
}
