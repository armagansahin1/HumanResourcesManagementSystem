package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class EducationManager implements EducationService{
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {

		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		
		setProperties(education);
		this.educationDao.save(education);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	

	@Override
	public DataResult<List<Education>> getAll() {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}
	
	private void setProperties(Education education) {
		education.setDepartmentName(education.getDepartmentName().trim().toUpperCase());
		education.setSchoolName(education.getSchoolName().trim().toUpperCase());
	}

	@Override
	public DataResult<List<Education>> getByCandidateIdOrderBygraduationDesc(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getByCandidate_IdOrderByGraduationDesc(candidateId));
	}
}
