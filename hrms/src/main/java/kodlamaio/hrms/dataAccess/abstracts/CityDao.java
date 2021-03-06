package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.City;


public interface CityDao extends JpaRepository<City,Integer>{
	 City getByCityName(String cityName);
	 List<City> getAllByOrderByCityNameAsc();
}
