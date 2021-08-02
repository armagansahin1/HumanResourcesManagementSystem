package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	
	List<JobAdvertisement> getByAdvertismentStatusTrueOrderByPublishDateDesc();
	List<JobAdvertisement> findAllByOrderByPublishDateDesc();
	
	List<JobAdvertisement> getByWorkTypeAndAdvertismentStatusTrue(String workType);
	
	@Query("Select j From JobAdvertisement j Where j.advertismentStatus=true Order By j.publishDate DESC")
	Page<JobAdvertisement> findAll(Pageable pageable);
}