package kodlamaio.hrms.dataAccess.abstracts;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDetailsDto;

public interface CandidateDao extends JpaRepository<Candidate,Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidateDetailsDto"
			+ "(c.id, u.firstName, u.lastName, c.profession, u.email, u.dateOfBirth) "
			+ "From User u Inner Join u.candidates c  Where c.id=:candidateId")
	CandidateDetailsDto getCandidateDetails(@Param(value = "candidateId") int candidateId);
	

}
