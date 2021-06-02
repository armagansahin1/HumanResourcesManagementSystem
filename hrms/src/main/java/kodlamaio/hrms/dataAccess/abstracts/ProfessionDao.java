package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Profession;

public interface ProfessionDao extends JpaRepository<Profession,Integer>{
	List<Profession> getByProfessionName(String professionName);
}
