package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	List<JobAdvertisement> getByAdvertismentStatusTrueOrderByRelaseDateDesc();
	List<JobAdvertisement> findAllByOrderByRelaseDateDesc();
	
	@Query("Select j From JobAdvertisement j Where j.advertismentStatus=true Order By j.relaseDate DESC")
	Page<JobAdvertisement> findAll(Pageable pageable);
}