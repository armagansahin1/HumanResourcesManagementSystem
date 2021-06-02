package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.BusinessExperience;

public interface BusinessExperienceDao extends JpaRepository<BusinessExperience,Integer>{
	List<BusinessExperience> getByCandidate_IdOrderByOutDateDesc(int candidateId);
}
