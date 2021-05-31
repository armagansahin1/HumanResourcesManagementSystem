package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Profession;

public interface ProfessionDao extends JpaRepository<Profession,Integer>{

}
