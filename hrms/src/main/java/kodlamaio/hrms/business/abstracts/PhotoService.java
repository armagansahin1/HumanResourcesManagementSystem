package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Photo;

public interface PhotoService {
	
	Result add(Photo photo);
	DataResult<Photo> getByCandidateId(int candidateId);
	DataResult<List<Photo>> getAll();
}
