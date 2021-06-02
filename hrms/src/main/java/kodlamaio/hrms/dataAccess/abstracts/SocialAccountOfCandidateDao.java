package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SocialAccountOfCandidate;

public interface SocialAccountOfCandidateDao extends JpaRepository<SocialAccountOfCandidate,Integer>{

}
